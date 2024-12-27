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
}
