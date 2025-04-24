package system.design.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.design.tracker.entity.Category;
import system.design.tracker.repository.CategoryRepository;
import system.design.tracker.repository.CategoryRepositoryMongo;

import java.util.List;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryDAO;

    @Autowired
    private CategoryRepositoryMongo categoryRepositoryMongo;

    public void addCategory(Category category) {
        categoryRepositoryMongo.insert(category);
    }

    public List<Category> fetchAllCategories() {
        return categoryRepositoryMongo.findAll();
    }

}
