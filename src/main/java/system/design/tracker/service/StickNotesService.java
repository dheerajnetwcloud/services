package system.design.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.design.tracker.controller.StickyNotesController;
import system.design.tracker.entity.Activity;
import system.design.tracker.entity.StickNotes;
import system.design.tracker.repository.ActivityRepository;
import system.design.tracker.repository.StickNotesRepository;

import java.util.List;

@Service
public class StickNotesService {
    @Autowired
    private StickNotesRepository stickNotesRepository;


    // ✅ Create a new activity
    public void createActivity(StickNotes stickyNotes) {
        stickNotesRepository.insert(stickyNotes);
    }

    // ✅ Retrieve all activities
    public List<StickNotes> getActivities() {
        return stickNotesRepository.findAll();
    }
}
