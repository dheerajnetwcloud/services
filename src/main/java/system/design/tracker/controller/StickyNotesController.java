package system.design.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.design.tracker.entity.Activity;
import system.design.tracker.entity.StickNotes;
import system.design.tracker.service.ActivityService;
import system.design.tracker.service.StickNotesService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/stickynotes")
@CrossOrigin(origins = "*")
public class StickyNotesController {


    @Autowired
    private StickNotesService stickNotesService;

    // ✅ GET: Retrieve all activities
    @GetMapping("/all")
    public List<StickNotes> getAllActivities() {
        return stickNotesService.getActivities();
    }

    // ✅ POST: Create a new activity
    @PostMapping
    public ResponseEntity<HashMap<String, String>> createActivity(@RequestBody StickNotes activity) {
        activity.setSeq(1);
        activity.setCreateDate(new Date());
        stickNotesService.createActivity(activity);
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Activity created successfully");
        return ResponseEntity.ok(response);
    }
}
