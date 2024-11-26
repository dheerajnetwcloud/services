package rest_guidlines.services.callendar.controller.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class Event {
    String description;
    Date startDate;
    Date endDate;
    String location;
    Boolean isRecurring;
}
