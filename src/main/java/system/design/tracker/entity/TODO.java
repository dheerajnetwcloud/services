package system.design.tracker.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@Data
@Document(collection = "todos")
public class TODO {
    @Id
    private String id;
    private String text;
    private Boolean status;
    private String category;
    private Date date;


}
