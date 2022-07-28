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

    @GetMapping(path = "/task")
    public ResponseEntity<MyResponseUtility> get(){
        response.data = taskService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/task/{id}")
    public ResponseEntity<MyResponseUtility> getById(@PathVariable("id") Integer id){
        response.data = taskService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/task")
    public ResponseEntity<MyResponseUtility> post(@RequestBody TaskDomain task){
        response.data = taskService.create(task);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "/task/{id}")
    public ResponseEntity<MyResponseUtility> put(@PathVariable("id") Integer id, @RequestBody TaskDomain task){

        TaskDomain taskUpdate = taskService.findById(id);

        taskUpdate.setName(task.getName());
        taskUpdate.setDescription(task.getDescription());
        taskUpdate.setColumn(task.getColumn());
        taskUpdate.setBoard(task.getBoard());
        taskUpdate.setDelivery(task.getDelivery());
        taskUpdate.setCreatedT(task.getCreatedT());
        taskUpdate.setUpdatedT(task.getUpdatedT());
        taskUpdate.setLogs(task.getLogs());

        response.data = taskService.update(taskUpdate);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping(path = "/task/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable("id") Integer id){

        response.data =  taskService.findById(id);
        taskService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
