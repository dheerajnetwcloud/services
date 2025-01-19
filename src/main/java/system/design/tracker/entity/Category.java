package system.design.tracker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class Category {
    private int id;
    private String name;
    private Date createDate;
}
