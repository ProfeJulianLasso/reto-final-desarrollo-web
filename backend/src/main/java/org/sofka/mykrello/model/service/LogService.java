package org.sofka.mykrello.model.service;

import java.util.List;
import java.util.Optional;

import org.sofka.mykrello.model.domain.LogDomain;
import org.sofka.mykrello.model.repository.LogRepository;
import org.sofka.mykrello.model.service.interfaces.LogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService implements LogServiceInterface {

    @Autowired
    private LogRepository logRepository;

<<<<<<< HEAD
    @Override
    public List<LogDomain> findAll() {
        return logRepository.findAll();
=======

    @Override
    public List<LogDomain> findAll() {
        return logRepository.findAll();
    }

    @Override
    public Optional<LogDomain> findById(Integer id) {
        return logRepository.findById(id);
>>>>>>> main
    }

    @Override
    public LogDomain create(LogDomain log) {
        return logRepository.save(log);
    }

    @Override
    public void delete(Integer id) {
        logRepository.deleteById(id);
    }

    @Override
    public void delete(Integer id) {
        logRepository.deleteById(id);
    }


}
