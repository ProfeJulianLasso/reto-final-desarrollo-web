package org.sofka.mykrello.model.service;

import org.sofka.mykrello.model.domain.ColumnDomain;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.service.interfaces.ColumnInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description Clase tipo Servicio para el manejo de las columnas
 * @Anotation Service
 */

@Service
public class ColumnService implements ColumnInterface {

    /**
     * Repositorio de Column
     */
    @Autowired
    private ColumnRepository columnRepository;

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve una lista de column
     * @return listado de Column
     ** @Anotation Override
     */
    @Override
    public List<ColumnDomain> findAll() {
        return columnRepository.findAll();
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve una Column de acuerdo al id
     * @param id Identificador de la Column
     * @return Column
     ** @Anotation Override
     */
    @Override
    public ColumnDomain findById(Integer id) {
        return null;
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Crea una Column de acuerdo a la informacion entregada
     * @param task Informacion de la Column
     * @return Column
     ** @Anotation Override
     */
    @Override
    public ColumnDomain create(ColumnDomain task) {
        return null;
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Actualiza una Column de acuerdo a la informacion entregada
     * @param task Informacion de la Column
     * @return Column
     ** @Anotation Override
     */
    @Override
    public ColumnDomain update(ColumnDomain task) {
        return null;
    }


    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description elimina una Column de acuerdo al id
     * @param id identificacion de la Column
     * @return Column
     ** @Anotation Override
     */
    @Override
    public void delete(Integer id) {

    }
}
