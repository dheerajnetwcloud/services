// src/main/java/system/design/tracker/entity/LeetCodeTracker.java
package system.design.tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "leetcode_tracker")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeetCodeTracker {
    @Id
    private String id;
    private String name;
    private String problem;
    private String description;
    private String status;
    private Date date;
    private String category;

}