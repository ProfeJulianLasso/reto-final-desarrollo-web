package org.sofka.mykrello.model.service;

import java.util.List;
import java.util.Optional;

import org.sofka.mykrello.model.domain.LogDomain;
import org.sofka.mykrello.model.repository.LogRepository;
import org.sofka.mykrello.model.service.interfaces.LogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description Clase tipo Servicio para el manejo del Log
 * @Anotation Service
 */
@Service
public class LogService implements LogServiceInterface {

    /**
     * Repositorio de Log
     */
    @Autowired
    private LogRepository logRepository;

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve una lista de Log
     * @return listado de Log
     ** @Anotation Override
     */
    @Override
    public List<LogDomain> findAll() {
        return logRepository.findAll();
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve un Log de acuerdo al id
     * @param id Identificador del Log
     * @return Log
     ** @Anotation Override
     */
    @Override
    public Optional<LogDomain> findById(Integer id) {
        return logRepository.findById(id);
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Crea un Log de acuerdo a la informacion entregada
     * @param log Informacion del Log
     * @return Log
     ** @Anotation Override
     */
    @Override
    public LogDomain create(LogDomain log) {
        return logRepository.save(log);
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description elimina un log de acuerdo al id
     * @param id identificacion del Log
     * @return Log
     ** @Anotation Override
     */
    @Override
    public void delete(Integer id) {
        logRepository.deleteById(id);
    }

}