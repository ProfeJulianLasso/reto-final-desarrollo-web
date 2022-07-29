package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.service.TaskService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*")
@RestController
/**
 * La clase TaskService es la encargada de realizar
 * las operaciones de CRUD de la entidad Task.
 */
public class TaskController {

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private TaskService taskService;

}
