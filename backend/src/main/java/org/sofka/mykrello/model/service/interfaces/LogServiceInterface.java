package org.sofka.mykrello.model.service.interfaces;

import java.util.List;

import org.sofka.mykrello.model.domain.LogDomain;

public interface LogServiceInterface {
    public  LogDomain findById(Integer id);
    public LogDomain create(LogDomain log);

}
