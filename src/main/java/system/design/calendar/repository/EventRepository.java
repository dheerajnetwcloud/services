package system.design.calendar.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import system.design.calendar.entity.Event;
import system.design.calendar.entity.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Event> getEvents(User user){
        String sql = "SELECT * FROM users";
        jdbcTemplate.queryForList(sql);
        System.out.println(jdbcTemplate.queryForList(sql));
        List<Event> events = new ArrayList<>();

        return events;
    }
}
