package system.design.tracker.controller;

// src/main/java/system/design/tracker/controller/TODOController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import system.design.tracker.entity.TODO;
import system.design.tracker.service.TODOService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*")
public class TODOController {
    @Autowired
    private TODOService todoService;

    @PostMapping
    public TODO createTODO(@RequestBody TODO todo) {
        if(todo.getDate() == null)
            todo.setDate(new Date());
        return todoService.createTODO(todo);
    }

    @GetMapping
    public List<TODO> getTODOs() {
        return todoService.getTODOs();
    }

    @PutMapping("/{id}")
    public TODO updateTODOStatus(@PathVariable String id, @RequestBody TODO todo) {
        return todoService.updateTODOStatus(id, todo);
    }
}
