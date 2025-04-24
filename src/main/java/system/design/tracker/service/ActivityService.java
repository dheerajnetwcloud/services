package system.design.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.design.tracker.entity.Activity;
import system.design.tracker.repository.ActivityRepository;
import system.design.tracker.repository.ActivityRepositoryMongo;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private system.design.tracker.repository.ActivityRepositoryMongo ActivityRepositoryMongo;

    // ✅ Create a new activity
    public void createActivity(Activity activity) {
        ActivityRepositoryMongo.insert(activity);
    }

    // ✅ Retrieve all activities
    public List<Activity> getActivities() {
        return ActivityRepositoryMongo.findAll();
    }
}
