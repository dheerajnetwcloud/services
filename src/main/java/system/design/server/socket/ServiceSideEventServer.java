package system.design.server.socket;


import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ServiceSideEventServer {
    private static final Set<OutputStream> clients = new CopyOnWriteArraySet<>();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // SSE Endpoint
        server.createContext("/sse", exchange -> {
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set("Content-Type", "text/event-stream");
            exchange.getResponseHeaders().set("Cache-Control", "no-cache");
            exchange.getResponseHeaders().set("Connection", "keep-alive");
            exchange.sendResponseHeaders(200, 0);

            OutputStream os = exchange.getResponseBody();
            clients.add(os);

            System.out.println("Client connected to /sse");

            // Do not close the stream here to keep the connection alive
        });

        // Trigger updates to clients every 5 seconds
        new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    Thread.sleep(5000);
                    String message = "data: Server time = " + System.currentTimeMillis() + "\n\n";
                    for (OutputStream os : clients) {
                        try {
                            os.write(message.getBytes());
                            os.flush();
                        } catch (IOException e) {
                            clients.remove(os); // remove dead connections
                        }
                    }
                    System.out.println("Sent update: " + count++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        server.start();
        System.out.println("SSE server running on http://localhost:8080/sse");
    }
}

