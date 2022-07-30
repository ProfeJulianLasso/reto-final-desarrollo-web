package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.domain.LogDomain;
import org.sofka.mykrello.model.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/log")
    public List<LogDomain> getAll(){
        return logService.findAll();
    }

    @DeleteMapping("/log/{id}")
    public void delete(@PathVariable("id") Integer id){
        logService.delete(id);
    }

}
