package system.design.tracker.repository;

// src/main/java/system/design/tracker/repository/TODORepository.java

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import system.design.tracker.entity.TODO;

@Repository
public interface TODORepository extends MongoRepository<TODO, String> {
}
