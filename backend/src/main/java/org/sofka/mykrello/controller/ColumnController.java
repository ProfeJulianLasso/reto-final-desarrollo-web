package org.sofka.mykrello.controller;


import org.sofka.mykrello.model.service.ColumnService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //@RestController anotacion que indica que esta clase es un controlador de rest
@CrossOrigin(value = "*") //@CrossOrigin anotacion que indica que esta clase se puede llamar desde cualquier origen
/**
 * @author Jorge Montoya
 * @author Juan David Quimbayo
 * @version 1.0
 */
public class ColumnController {

    /**
     *La clase ColumnController contiene los metodos para
     * la creacion, actualizacion, eliminacion y obtencion de columnas
     */
    @Autowired
    private MyResponseUtility response;
    @Autowired
    private ColumnService columnService;

    /**
     * El metodo getColumn obtiene una lista de columnas
     * @return ResponseEntity<ColumnDomain>
     */
    @GetMapping(path = "/api/v1/column")
    public ResponseEntity<MyResponseUtility> getColumn() {
        response.data = columnService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


   /* @PostMapping(path = "/api/v1/log")
    public ResponseEntity<MyResponseUtility> create(@RequestBody LogDomain log) {
        response.data = logService.create(log);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "/api/v1/log/{id}")
    public ResponseEntity<MyResponseUtility> put(@PathVariable(value = "id") Integer id,
            @RequestBody LogDomain log) {
        response.data = logService.update(id, log);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }*/

   /* @DeleteMapping(path = "/api/v1/log/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable(value = "id") Integer id) {
        response.data = logService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }*/

    /* @GetMapping(path = "/api/v1/log")
    public ResponseEntity<MyResponseUtility> index() {
        response.data = logService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

}
