package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.service.ColumnService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class ColumnController {

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private ColumnService columnService;

    @GetMapping(path = "/column")
    public ResponseEntity<MyResponseUtility> getAll(){
        response.data = columnService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
