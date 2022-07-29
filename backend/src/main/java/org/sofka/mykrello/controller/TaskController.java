package org.sofka.mykrello.controller;


import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.service.TaskService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
public class TaskController {

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private TaskService taskService;
/*
   @GetMapping(path = "/api/v1/task")
    public ResponseEntity<MyResponseUtility> index() {
        response.data = taskService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/
    @GetMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<MyResponseUtility> getTaskById(@PathVariable(value = "id") Integer id) {
        response.data = taskService.findById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/task")
    public ResponseEntity<MyResponseUtility> create(@RequestBody TaskDomain task) {
        response.data = taskService.create(task);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<MyResponseUtility> put(@PathVariable(value = "id") Integer id,
                                                 @RequestBody TaskDomain task) {
        var b = taskService.update(id, task);
        response.data = b;
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable(value = "id") Integer id) {
        try {
            response.data = taskService.delete(id);

        }
        catch (Exception e){
            Integer x =0;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
