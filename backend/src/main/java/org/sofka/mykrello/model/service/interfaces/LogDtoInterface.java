package org.sofka.mykrello.model.service.interfaces;

import org.sofka.mykrello.model.domain.LogDto;

import java.util.Optional;

public interface LogDtoInterface {

    public LogDto findById(Integer id);

    public LogDto create(LogDto log);

    public LogDto update(LogDto log);
}
