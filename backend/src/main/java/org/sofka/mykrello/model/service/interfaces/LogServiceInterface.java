package org.sofka.mykrello.model.service.interfaces;

import java.util.List;

import org.sofka.mykrello.model.domain.LogDomain;

public interface LogServiceInterface {
    public List<LogDomain> findAll();
    public LogDomain create(LogDomain log);

    public void delete(Integer id);

}
