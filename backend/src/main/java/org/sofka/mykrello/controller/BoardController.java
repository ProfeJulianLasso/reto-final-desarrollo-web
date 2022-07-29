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

@RestController //@RestController indica que es un controlador REST
@CrossOrigin(value = "*") //@CrossOrigin indica que se puede acceder desde cualquier origen
public class BoardController {

    @Autowired
    private MyResponseUtility response;
    @Autowired
    private BoardService boardService;//


    /**
     * Metodo que retorna todos los registros de la tabla Board.
     * @return ResponseEntity<MyResponseUtility>
     */
    @GetMapping(path = "/api/v1/boards")
    public ResponseEntity<MyResponseUtility> index() {
        response.data = boardService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * Metodo que retorna un registro de la tabla Board por su id.
     * @param id
     * @return ResponseEntity<MyResponseUtility>
     */
    @GetMapping(path = "/api/v1/board/{id}")
    public ResponseEntity<MyResponseUtility> getBoardById(@PathVariable(value = "id") Integer id) {
        response.data = boardService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * Metodo que crea un nuevo registro en la tabla Board.
     * @param board
     * @return ResponseEntity<MyResponseUtility>
     */
    @PostMapping(path = "/api/v1/board")
    public ResponseEntity<MyResponseUtility> create(@RequestBody BoardDomain board) {
        response.data = boardService.create(board);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    /**
     * Metodo que actualiza un registro de la tabla Board.
     * @param id
     * @param board
     * @return ResponseEntity<MyResponseUtility>
     */
    @PutMapping(path = "/api/v1/board/{id}")
    public ResponseEntity<MyResponseUtility> put(@PathVariable(value = "id") Integer id,
                                                 @RequestBody BoardDomain board) {
        response.data = boardService.update(id, board);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    /**
     * Metodo que elimina un registro de la tabla Board.
     * @param id
     * @return ResponseEntity<MyResponseUtility>
     */
    @DeleteMapping(path = "/api/v1/board/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable(value = "id") Integer id) {
        try {
            response.data = boardService.delete(id);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){

            return null;

        }
    }
}


