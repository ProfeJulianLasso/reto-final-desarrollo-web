package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.service.ColumnForBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Author Sebastian santis - Sebastian Torres
 * @Description La clase ColumnForBoardController se encarga de recibir informacion desde el cliente y enviarla a la base de datos y viceversa mediante las distintas anotaciones basicas utilizadas para un CRUD
 * @Params None
 * @Anotations RestController - CrossOrigin
 */

@RestController
@CrossOrigin(value = "*")
public class ColumnForBoardController {

    @Autowired
    private MyResponseUtility response;
    @Autowired
    private ColumnForBoardService columnForBoardService;

    /***
     * @Author Sebastian santis - Sebastian Torres
     * @Description El metodo get nos ayuda a enviarle al cliente la informacion disponible en la base de datos de todos las columnas disponibles dentro de un tablero que estan registradas
     * @Params none
     * @Anotations @GetMapping <- Utilizada para lanzar el metodo GET dentro de Spring
     */

    @GetMapping(path = "/columnForBoard")
    public ResponseEntity<MyResponseUtility> get(){

        response.data = columnForBoardService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
