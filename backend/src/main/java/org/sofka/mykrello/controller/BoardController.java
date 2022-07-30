package org.sofka.mykrello.controller;

import org.sofka.mykrello.controller.domain.BoardDomain;
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

@RestController//@RestController anotacion que indica que esta clase es un controlador de rest
@CrossOrigin(value = "*") //@CrossOrigin anotacion que indica que esta clase se puede llamar desde cualquier origen
/**
 * @author Jorge Montoya
 * @author Juan David Quimbayo
 * @version 1.0
 */
public class BoardController {

    @Autowired
    private MyResponseUtility response;
    @Autowired
    private BoardService boardService;


    /**
     * El metodo getBoard obtiene una lista de boards
     * @return ResponseEntity<BoardDomain>
     */
    @GetMapping(path = "/api/v1/board")
    public ResponseEntity<MyResponseUtility> index() {
        response.data = boardService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * El metodo getBoard obtiene una lista de boards
     * @return ResponseEntity<BoardDomain>
     */
    @GetMapping(path = "/api/v1/board/{id}")
    public ResponseEntity<MyResponseUtility> getBoardById(@PathVariable(value = "id") Integer id) {
        response.data = boardService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * El metodo createBoard crea un board
     * @return ResponseEntity<BoardDomain>
     */
    @PostMapping(path = "/api/v1/board")
    public ResponseEntity<MyResponseUtility> create(@RequestBody BoardDomain board) {
        response.data = boardService.create(board);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    /**
     * El metodo updateBoard actualiza un board
     * @return ResponseEntity<BoardDomain>
     */
    @PutMapping(path = "/api/v1/board/{id}")
    public ResponseEntity<MyResponseUtility> put(@PathVariable(value = "id") Integer id,
            @RequestBody BoardDomain board) {
        response.data = boardService.update(id, board);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    /**
     * El metodo deleteBoard elimina un board
     * @return ResponseEntity<BoardDomain>
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
