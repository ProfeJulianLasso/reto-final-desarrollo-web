package org.sofka.mykrello.model.service;

import org.sofka.mykrello.model.domain.ColumnForBoardDomain;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.service.interfaces.ColumnForBoardInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description Clase tipo Servicio para el manejo de la Columna para tablero
 * @Anotation Service
 */
@Service
public class ColumnForBoardService implements ColumnForBoardInterface {

    /**
     * Repositorio de ColumnForBoard
     */
    @Autowired
    private ColumnForBoardRepository columnForBoardRepository;

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve una lista de ColumnForBoard
     * @return listado de ColumnForBoardDomain
     ** @Anotation Override
     */
    @Override
    public List<ColumnForBoardDomain> findAll() {
        return columnForBoardRepository.findAll();
    }


    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve un ColumnForBoard de acuerdo al id
     * @param id Identificador del ColumnForBoard
     * @return ColumnForBoard
     ** @Anotation Override
     */
    @Override
    public ColumnForBoardDomain findById(Integer id) {
        return null;
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Crea un ColumnForBoard de acuerdo a la informacion entregada
     * @param task Informacion de ColumnForBoard
     * @return ColumnForBoard
     ** @Anotation Override
     */
    @Override
    public ColumnForBoardDomain create(ColumnForBoardDomain task) {
        return null;
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Actualiza un ColumnForBoard de acuerdo a la informacion entregada
     * @param task Informacion de ColumnForBoard
     * @return ColumnForBoard
     ** @Anotation Override
     */
    @Override
    public ColumnForBoardDomain update(ColumnForBoardDomain task) {
        return null;
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description elimina un ColumnForBoard de acuerdo al id
     * @param id identificacion del ColumnForBoard
     * @return ColumnForBoard
     ** @Anotation Override
     */
    @Override
    public void delete(Integer id) {

    }
}
