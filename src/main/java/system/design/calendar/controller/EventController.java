package system.design.calendar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.design.calendar.entity.Event;

@RestController
@RequestMapping("/api")
public class EventController {

    @GetMapping("/getEvents")
    public Event getEvents() {
        Event event = new Event();
        event.setDescription("This is EVENT");
        event.setLocation("zoom://please/join/my/zoom");
        return event;
    }
}
