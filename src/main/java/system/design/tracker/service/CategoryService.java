package system.design.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.design.tracker.entity.Category;
import system.design.tracker.repository.CategoryRepository;

import java.util.List;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryDAO;

    public void addCategory(Category category) {
        categoryDAO.insertCategory(category);
    }

    public List<Category> fetchAllCategories() {
        return categoryDAO.getAllCategories();
    }
}
