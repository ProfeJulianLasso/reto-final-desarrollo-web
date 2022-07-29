package org.sofka.mykrello.model.service.interfaces;


import org.sofka.mykrello.model.domain.DTO.ColumnOutDomain;

import java.util.List;

public interface ColumnServiceInterface {
    public List<ColumnOutDomain> findAll();

}
