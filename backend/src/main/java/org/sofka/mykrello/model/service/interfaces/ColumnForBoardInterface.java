package org.sofka.mykrello.model.service.interfaces;

import org.sofka.mykrello.model.domain.ColumnForBoardDomain;

import java.util.List;

/**
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description interfaz de servicio del dominio ColumnForBoard
 */

public interface ColumnForBoardInterface {

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve el listado columnas para tablero existentes
     * @return Listado de ColumnForBoardDomain
     */
    public List<ColumnForBoardDomain> findAll();

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Busca una columna para tablero de acuerdo al identificador
     * @param id Identificador de la columna para tablero
     * @return ColumnForBoardDomain
     */
    public ColumnForBoardDomain findById(Integer id);

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Crea una columna para tablero
     * @param task datos de la columna para tablero
     * @return ColumnForBoardDomain
     */
    public ColumnForBoardDomain create(ColumnForBoardDomain task);

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Actualiza una columna para tablero
     * @param task datos de la columna para tablero para actualizar
     * @return ColumnForBoardDomain
     */
    public ColumnForBoardDomain update(ColumnForBoardDomain task);

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description elimina una columna para tablero
     * @param id identificador de la columna para tablero a eliminar
     * @return ColumnForBoardDomain
     */
    public void delete(Integer id);

}
