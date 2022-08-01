package org.sofka.mykrello.model.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sofka.mykrello.model.domain.LogDomain;


/**
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description interfaz de servicio del dominio Log
 */

public interface LogServiceInterface {

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve el listado de logs existentes
     * @return Listado de Log
     */
    public List<LogDomain> findAll();

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Busca unlog de acuerdo al identificador
     * @param id Identificador del log
     * @return log
     */
    public Optional<LogDomain> findById(Integer id);

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Crea un Log
     * @param log datos para la creacion del log
     * @return Log
     */
    public LogDomain create(LogDomain log);

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description elimina un Log
     * @param id identificador del Log a eliminar
     * @return Log
     */
    public void delete(Integer id);
}