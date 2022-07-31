package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.domain.BoardDomain;
import org.sofka.mykrello.model.service.BoardService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/***
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description La clase BoardController se encarga de recibir informacion desde el cliente y enviarla a la base de datos y viceversa mediante las distintas anotaciones basicas utilizadas para un CRUD
 * @Params None
 * @Anotations RestController - CrossOrigin
 */

@RestController
@CrossOrigin(value = "*")
public class BoardController {

    @Autowired
    private MyResponseUtility response;
    @Autowired
    private BoardService boardService;

    /***
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description El metodo index nos ayuda a enviarle al cliente la informacion disponible en la base de datos de todos los tablero que estan registrado, con este metodo le enviamos no solo la informacion de los tableros si no tambien las columnas internas que tiene y las tareas que estan inmersas dentro de cada uno
     * @Params none
     * @Anotations @GetMapping <- Utilizada para lanzar el metodo GET dentro de Spring
     */

    @GetMapping(path = "/board")
    public ResponseEntity<MyResponseUtility> index() {
        response.data = boardService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /***
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description El metodo getBoardById obtiene la informacion completa de un tablero con tareas y columnas pero mediante de su id
     * @Params Integer id <- id perteneciente al tablero a buscar
     * @Anotations @GetMapping <- Utilizada para lanzar el metodo GET dentro de Spring
     */

    @GetMapping(path = "/board/{id}")
    public ResponseEntity<MyResponseUtility> getBoardById(@PathVariable(value = "id") Integer id) {
        response.data = boardService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /***
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description El metodo create le envia a la base de datos la informacion necesaria para inscribir y almacenar un nuevo tablero
     * @Params BoardDomain board <- clase mapeada desde spring para realizar el envio y persistencia de la informacion enviada por el usuari
     * @Anotations @PostMapping <- Utilizada para lanzar el metodo POST dentro de Spring
     */

    @PostMapping(path = "/board")
    public ResponseEntity<MyResponseUtility> create(@RequestBody BoardDomain board) {
        response.data = boardService.create(board);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /***
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description El metodo put actualiza la informacion mediante el id recibido y los datos enviados por el cliente
     * @Params BoardDomain board <- clase mapeada desde spring para realizar el envio y persistencia de la informacion enviada por el usuari
     * @Params Intger id <- id perteneciente al tablero a buscar
     * @Anotations @PutMapping <- Utilizada para lanzar el metodo PUT dentro de Spring
     */

    @PutMapping(path = "/board/{id}")
    public ResponseEntity<MyResponseUtility> put(@PathVariable(value = "id") Integer id, @RequestBody BoardDomain board) {
        response.data = boardService.update(id, board);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /***
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description El metodo delete elimina la informacion mediante el id recibido
     * @Params Intger id <- id perteneciente al tablero a buscar
     * @Anotations @DeleteMapping <- Utilizada para lanzar el metodo DELETE dentro de Spring
     */

    @DeleteMapping(path = "/board/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable(value = "id") Integer id) {
        response.data = boardService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
