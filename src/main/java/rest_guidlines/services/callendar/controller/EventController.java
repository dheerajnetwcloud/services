package rest_guidlines.services.callendar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest_guidlines.services.callendar.controller.entity.Event;

@RestController
@RequestMapping("/api")
public class EventController {

    @GetMapping("/getEvents")
    public Event sayHello() {
        Event event = new Event();
        event.setDescription("This is EVENT");
        event.setLocation("zoom://please/join/my/zoom");
        return event;
    }
}
