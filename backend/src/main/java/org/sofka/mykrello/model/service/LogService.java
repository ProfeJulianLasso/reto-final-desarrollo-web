package org.sofka.mykrello.model.service;

import java.util.List;

import org.sofka.mykrello.model.domain.LogDomain;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.repository.LogRepository;
import org.sofka.mykrello.model.service.interfaces.LogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService implements LogServiceInterface {
    @Autowired
    private LogRepository logRepository;
    @Override
    public LogDomain findById(Integer id) {
        // TODO Auto-generated method stub
        var a = logRepository.findById(id);
        return a.get();
    }

    @Override
    public LogDomain create(LogDomain log) {
        var logDomain = logRepository.save(log);
        return logDomain;
    }


}
