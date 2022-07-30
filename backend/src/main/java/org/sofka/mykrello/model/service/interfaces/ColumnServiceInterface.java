package org.sofka.mykrello.model.service.interfaces;


import org.sofka.mykrello.controller.domain.DTO.ColumnOutDomain;

import java.util.List;

/**
 * ColumnServiceInterface es una interface que contiene los metodos
 * que se utilizan para el manejo de las columnas
 */
public interface ColumnServiceInterface {
    public List<ColumnOutDomain> findAll();

}
