package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.service.ColumnService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Author Sebastian santis - Sebastian Torres
 * @Description La clase ColumnController se encarga de recibir informacion desde el cliente y enviarla a la base de datos y viceversa mediante las distintas anotaciones basicas utilizadas para un CRUD
 * @Params None
 * @Anotations RestController - CrossOrigin
 */

@RestController
@CrossOrigin(value = "*")
public class ColumnController {

    @Autowired
    private MyResponseUtility response;
    @Autowired
    private ColumnService columnService;

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo getAll nos ayuda a enviarle al cliente la informacion disponible en la base de datos de todos las columnas que estan registradas
     * @Params none
     * @Anotations @GetMapping <- Utilizada para lanzar el metodo GET dentro de Spring
     */

    @GetMapping(path = "/column")
    public ResponseEntity<MyResponseUtility> getAll(){
        response.data = columnService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
