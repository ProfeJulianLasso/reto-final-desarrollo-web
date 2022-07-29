package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.service.ColumnForBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class ColumnForBoardController {

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private ColumnForBoardService columnForBoardService;

    @GetMapping(path = "/columnForBoard")
    public ResponseEntity<MyResponseUtility> get(){

        response.data = columnForBoardService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
