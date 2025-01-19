package system.design.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.design.tracker.entity.Activity;
import system.design.tracker.repository.ActivityRepository;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    // ✅ Create a new activity
    public void createActivity(Activity activity) {
        activityRepository.insertActivity(activity);
    }

    // ✅ Retrieve all activities
    public List<Activity> getActivities() {
        return activityRepository.getAllActivities();
    }
}
