package system.design.tracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import system.design.tracker.entity.Category;
import system.design.tracker.entity.StickNotes;

public interface StickNotesRepository extends MongoRepository<StickNotes, String> {

}

