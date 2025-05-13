package system.design.tracker.service;

// src/main/java/system/design/tracker/service/TODOServicel.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.design.tracker.entity.TODO;
import system.design.tracker.repository.TODORepository;

import java.util.List;

@Service
public class TODOService {
    @Autowired
    private TODORepository todoRepository;

    public TODO createTODO(TODO todo) {
        return todoRepository.save(todo);
    }

    public List<TODO> getTODOs() {
        return todoRepository.findAll();
    }

    public TODO updateTODOStatus(String id, TODO todoStatus) {
        TODO todo = todoRepository.findById(id).orElseThrow();
        todo.setDone(todoStatus.getDone());
        return todoRepository.save(todo);
    }
}
