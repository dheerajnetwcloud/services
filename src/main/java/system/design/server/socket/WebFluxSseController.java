//package system.design.server.socket;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//import system.design.tracker.service.LeetCodeTrackerService;
//
//import java.time.Duration;
//import java.time.LocalTime;
//
//@RestController
//public class WebFluxSseController {
//
//    @Autowired
//    LeetCodeTrackerService leetcodeTrackerService;
//
//    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<String> streamTime() {
//
//        return Flux.interval(Duration.ofSeconds(1))
//                .map(sequence -> LocalTime.now().toString());
//    }
//}
