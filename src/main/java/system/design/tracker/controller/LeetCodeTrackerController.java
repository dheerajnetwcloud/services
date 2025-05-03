// src/main/java/system/design/tracker/controller/LeetCodeTrackerController.java
package system.design.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import system.design.tracker.entity.LeetCodeTracker;
import system.design.tracker.service.LeetCodeTrackerService;

import java.util.List;

@RestController
@RequestMapping("/api/leetcode")
@CrossOrigin(origins = "*")
public class LeetCodeTrackerController {
    private final LeetCodeTrackerService leetCodeTrackerService;

    @Autowired
    public LeetCodeTrackerController(LeetCodeTrackerService leetCodeTrackerService) {
        this.leetCodeTrackerService = leetCodeTrackerService;
    }

    @GetMapping("/all")
    public List<LeetCodeTracker> getAllLeetCodeTrackers() {
        return leetCodeTrackerService.getAllLeetCodeTrackers();
    }

    @GetMapping("/{id}")
    public LeetCodeTracker getLeetCodeTrackerById(@PathVariable String id) {
        return leetCodeTrackerService.getLeetCodeTrackerById(id);
    }

    @PostMapping
    public LeetCodeTracker createLeetCodeTracker(@RequestBody LeetCodeTracker leetCodeTracker) {
        return leetCodeTrackerService.createLeetCodeTracker(leetCodeTracker);
    }

    @GetMapping("/trackers")
    public Page<LeetCodeTracker> getLeetCodeTrackersByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return leetCodeTrackerService.getLeetCodeTrackersByPagination(page, size);
    }
}