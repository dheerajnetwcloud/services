package system.design.calendar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
public class Event {
    String description;
    Date startDate;
    Date endDate;
    String location;
    User creator;
    List<User> recipients;


    //There is one to many mapping relation between event and recurring relation
    //what is your requirement here
    //I want to get all the events of a user
    //to get all the recurring event of a user, you need to fetch it from the recurring event
    //you should allso get the
}
