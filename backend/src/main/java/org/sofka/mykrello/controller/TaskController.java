package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.service.TaskService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * @Author Sebastian santis - Sebastian Torres
 * @Description La clase TaskController se encarga de recibir informacion desde el cliente y enviarla a la base de datos y viceversa mediante las distintas anotaciones basicas utilizadas para un CRUD
 * @Params None
 * @Anotations RestController - CrossOrigin
 */

@CrossOrigin(value = "*")
@RestController
public class TaskController {

    @Autowired
    private MyResponseUtility response;
    @Autowired
    private TaskService taskService;

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo get nos ayuda a enviarle al cliente la informacion disponible en la base de datos de las tareas creadas
     * @Params none
     * @Anotations @GetMapping <- Utilizada para lanzar el metodo GET dentro de Spring
     */

    @GetMapping(path = "/task")
    public ResponseEntity<MyResponseUtility> get(){
        response.data = taskService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo getById obtiene la informacion completa de una tarea mediante de su id
     * @Params Integer id <- id perteneciente a la tarea a buscar
     * @Anotations @GetMapping <- Utilizada para lanzar el metodo GET dentro de Spring
     */

    @GetMapping(path = "/task/{id}")
    public ResponseEntity<MyResponseUtility> getById(@PathVariable("id") Integer id){
        response.data = taskService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo post le envia a la base de datos la informacion necesaria para inscribir y almacenar una nueva tarea
     * @Params TaskDomain task <- clase mapeada desde spring para realizar el envio y persistencia de la informacion enviada por el usuario
     * @Anotations @PostMapping <- Utilizada para lanzar el metodo POST dentro de Spring
     */

    @PostMapping("/task")
    public ResponseEntity<MyResponseUtility> post(@RequestBody TaskDomain task){
        response.data = taskService.create(task);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo put actualiza la informacion mediante el id recibido y los datos enviados por el cliente
     * @Params TaskDomain task <- clase mapeada desde spring para realizar el envio y persistencia de la informacion enviada por el usuari
     * @Params Intger id <- id perteneciente a la tarea a buscar
     * @Anotations @PutMapping <- Utilizada para lanzar el metodo PUT dentro de Spring
     */

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

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo delete elimina la informacion mediante el id recibido
     * @Params Intger id <- id perteneciente a la tarea a buscar
     * @Anotations @DeleteMapping <- Utilizada para lanzar el metodo DELETE dentro de Spring
     */

    @DeleteMapping(path = "/task/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable("id") Integer id){

        response.data =  taskService.findById(id);
        taskService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
