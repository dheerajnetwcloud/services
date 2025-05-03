// src/main/java/system/design/tracker/repository/LeetCodeTrackerRepository.java
package system.design.tracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import system.design.tracker.entity.LeetCodeTracker;

@Repository
public interface LeetCodeTrackerRepository extends MongoRepository<LeetCodeTracker, String> {
}