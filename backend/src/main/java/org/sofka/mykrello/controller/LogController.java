package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.domain.LogDto;
import org.sofka.mykrello.model.service.LogDtoService;
import org.sofka.mykrello.model.service.LogService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * @Author Sebastian santis - Sebastian Torres
 * @Description La clase LogController se encarga de recibir informacion desde el cliente y enviarla a la base de datos y viceversa mediante las distintas anotaciones basicas utilizadas para un CRUD
 * @Params None
 * @Anotations RestController - CrossOrigin
 */

@CrossOrigin(value = "*")
@RestController
public class LogController {

    @Autowired
    private MyResponseUtility response;
    @Autowired
    private LogService logService;
    @Autowired
    private LogDtoService logDtoService;

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo get nos ayuda a enviarle al cliente la informacion disponible en la base de datos de los logs creados por actualizacion de tareas
     * @Params none
     * @Anotations @GetMapping <- Utilizada para lanzar el metodo GET dentro de Spring
     */

    @GetMapping(path = "/log")
    public ResponseEntity<MyResponseUtility> get(){
        response.data = logDtoService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo getById obtiene la informacion completa de un log mediante de su id
     * @Params Integer id <- id perteneciente al log a buscar
     * @Anotations @GetMapping <- Utilizada para lanzar el metodo GET dentro de Spring
     */

    @GetMapping(path = "/log/{id}")
    public ResponseEntity<MyResponseUtility> getById(@PathVariable("id") Integer id){
        response.data = logDtoService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo post le envia a la base de datos la informacion necesaria para inscribir y almacenar un nuevo log
     * @Params LogDto log <- clase mapeada desde spring para realizar el envio y persistencia de la informacion enviada por el usuario
     * @Anotations @PostMapping <- Utilizada para lanzar el metodo POST dentro de Spring
     */

    @PostMapping(path= "/log")
    public ResponseEntity<MyResponseUtility> post(@RequestBody LogDto log){
        response.data = logDtoService.create(log);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo put actualiza la informacion mediante el id recibido y los datos enviados por el cliente
     * @Params LogDto log <- clase mapeada desde spring para realizar el envio y persistencia de la informacion enviada por el usuari
     * @Params Intger id <- id perteneciente al log a buscar
     * @Anotations @PutMapping <- Utilizada para lanzar el metodo PUT dentro de Spring
     */

    @PutMapping(path= "/log/{id}")
    public ResponseEntity<MyResponseUtility> put(@PathVariable("id") Integer id, @RequestBody LogDto log){
        LogDto logUpdate = logDtoService.findById(id);

        logUpdate.setTaskId(log.getTaskId());
        logUpdate.setColumnaPrevious(log.getColumnaPrevious());
        logUpdate.setColumnaCurrent(log.getColumnaCurrent());


        response.data = logDtoService.update(logUpdate);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo delete elimina la informacion mediante el id recibido
     * @Params Intger id <- id perteneciente al log a buscar
     * @Anotations @DeleteMapping <- Utilizada para lanzar el metodo DELETE dentro de Spring
     */

    @DeleteMapping(path = "/log/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable("id") Integer id){

        response.data =  logService.findById(id);
        logService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}