package system.design.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.design.calendar.entity.Event;
import system.design.tracker.entity.Category;
import system.design.tracker.service.CategoryService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class TrackerController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategories() {
        System.out.println("Getting all the Categories");
        return categoryService.fetchAllCategories();
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        try {
            // Set the creation date
            category.setCreateDate(new Date());
            categoryService.addCategory(category);
            return new ResponseEntity<>("Category created successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create category: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
