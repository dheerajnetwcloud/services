package system.design.calendar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.design.calendar.entity.Event;
import system.design.calendar.entity.User;
import system.design.calendar.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventManagement {

    @Autowired
    EventRepository repository;

    public List<Event> getEvents(User user){
        return repository.getEvents(user);
    }
}
