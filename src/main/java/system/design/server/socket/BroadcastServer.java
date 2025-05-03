//package system.design.server.socket;
//
//import jakarta.websocket.server.ServerEndpoint;
//
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//
//@ServerEndpoint("/ws")
//public class BroadcastServer {
//
//    private static final Set<Session> clients = Collections.synchronizedSet(new HashSet<>());
//
//    @OnOpen
//    public void onOpen(Session session) {
//        clients.add(session);
//        System.out.println("New client connected: " + session.getId());
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session senderSession) throws IOException {
//        System.out.println("Received: " + message);
//        broadcast("User " + senderSession.getId() + ": " + message);
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        clients.remove(session);
//        System.out.println("Client disconnected: " + session.getId());
//    }
//
//    private void broadcast(String message) throws IOException {
//        synchronized (clients) {
//            for (Session client : clients) {
//                if (client.isOpen()) {
//                    client.getBasicRemote().sendText(message);
//                }
//            }
//        }
//    }
//}
//
