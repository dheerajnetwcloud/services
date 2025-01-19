package system.design.tracker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@Data
public class Activity {
        private int id;
        private String category;
        private String description;
        private String comments;
        private LocalDateTime createdAt;
}
