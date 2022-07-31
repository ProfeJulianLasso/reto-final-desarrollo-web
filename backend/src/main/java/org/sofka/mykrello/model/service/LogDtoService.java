package org.sofka.mykrello.model.service;

import org.sofka.mykrello.model.domain.LogDto;
import org.sofka.mykrello.model.repository.LogDtoRepository;
import org.sofka.mykrello.model.service.interfaces.LogDtoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LogDtoService implements LogDtoInterface {

    @Autowired
    private LogDtoRepository logDtoRepository;

    public List<LogDto> findAll(){
        return logDtoRepository.findAll();
    }

    @Override
    public LogDto findById(Integer id) {
        Optional<LogDto> log = logDtoRepository.findById(id);
        return log.orElse(null);
    }
    @Override
    public LogDto create(LogDto log) {
        return logDtoRepository.save(log);
    }

    @Override
    public LogDto update(LogDto log) {
        return logDtoRepository.save(log);
    }
}
