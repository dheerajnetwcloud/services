package system.design.tracker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@Data
@Document(collection = "category")
public class Category {
    @Id
    private String _id;
    private int seq;
    private String name;
    private Date createDate;
}
