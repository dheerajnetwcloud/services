package system.design.tracker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@NoArgsConstructor
@Data
@Document(collection = "daily_activity")
public class Activity {
        @Id
        private String id;

        private int seq;
                private String category;
        private String description;
        private String comments;
        private LocalDateTime createdAt;
}
