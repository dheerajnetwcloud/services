package system.design.tracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.design.tracker.entity.Activity;
import system.design.tracker.service.ActivityService;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@CrossOrigin(origins = "*")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // ✅ GET: Retrieve all activities
    @GetMapping("/all")
    public List<Activity> getAllActivities() {
        return activityService.getActivities();
    }

    // ✅ POST: Create a new activity
    @PostMapping
    public ResponseEntity<String> createActivity(@RequestBody Activity activity) {
        activityService.createActivity(activity);
        return ResponseEntity.ok("Activity created successfully");
    }
}
