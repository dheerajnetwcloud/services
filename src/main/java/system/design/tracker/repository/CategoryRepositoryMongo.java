package system.design.tracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import system.design.tracker.entity.Category;

public interface CategoryRepositoryMongo extends MongoRepository<Category, String> {

}
