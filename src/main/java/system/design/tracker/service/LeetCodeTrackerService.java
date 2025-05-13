// src/main/java/system/design/tracker/service/LeetCodeTrackerService.java
package system.design.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import system.design.tracker.entity.LeetCodeTracker;
import system.design.tracker.repository.LeetCodeTrackerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class LeetCodeTrackerService {
    private final LeetCodeTrackerRepository leetCodeTrackerRepository;

    @Autowired
    public LeetCodeTrackerService(LeetCodeTrackerRepository leetCodeTrackerRepository) {
        this.leetCodeTrackerRepository = leetCodeTrackerRepository;
    }

    public List<LeetCodeTracker> getAllLeetCodeTrackers() {
        Sort sort = Sort.by(Sort.Direction.DESC, "status");
        return leetCodeTrackerRepository.findAll(sort);
    }

    public LeetCodeTracker getLeetCodeTrackerById( String id) {
        return leetCodeTrackerRepository.findById(id).orElse(null);
    }

    public LeetCodeTracker createLeetCodeTracker(LeetCodeTracker leetCodeTracker) {

        if (leetCodeTracker.getProblem() == null) {
            throw new IllegalArgumentException("Problem is required");
        }
        if (leetCodeTracker.getDescription() == null) {
            throw new IllegalArgumentException("Description is required");
        }
        if (leetCodeTracker.getStatus() == null) {
            throw new IllegalArgumentException("Status is required");
        }
        return leetCodeTrackerRepository.save(leetCodeTracker);
    }
    public Page<LeetCodeTracker> getLeetCodeTrackersByPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return leetCodeTrackerRepository.findAll(pageable);
    }

    public long getLeetCodeTrackerCount() {
        return leetCodeTrackerRepository.count();
    }


}