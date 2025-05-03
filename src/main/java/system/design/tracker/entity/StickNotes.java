package system.design.tracker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@NoArgsConstructor
@Data
@Document(collection = "sticky_notes")
public class StickNotes {
        @Id
        private String _id;
        private int seq;
        private String note;
        private Date createDate;
}
