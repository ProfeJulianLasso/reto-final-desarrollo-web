package org.sofka.mykrello.model.service.interfaces;
import org.sofka.mykrello.controller.domain.LogDomain;


/**
 * LogServiceInterface una interface que contiene
 * los metodos que se utilizan para el manejo de las tareas.
 */
public interface LogServiceInterface {
    public  LogDomain findById(Integer id);
    public LogDomain create(LogDomain log);

}
