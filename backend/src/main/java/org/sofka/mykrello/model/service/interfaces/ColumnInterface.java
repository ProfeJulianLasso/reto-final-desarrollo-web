package org.sofka.mykrello.model.service.interfaces;

import org.sofka.mykrello.model.domain.ColumnDomain;
import java.util.List;

/**
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description interfaz de servicio del dominio Column
 */
public interface ColumnInterface {

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve el listado columnas existentes
     * @return Listado de Columnas
     */
    public List<ColumnDomain> findAll();

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Busca una columna de acuerdo al identificador
     * @param id Identificador de la columna
     * @return Columna
     */
    public ColumnDomain findById(Integer id);

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Crea una columna
     * @param task datos de la columna
     * @return Column
     */
    public ColumnDomain create(ColumnDomain task);

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Actualiza una columna
     * @param task datos de la columna para actualizar
     * @return Column
     */
    public ColumnDomain update(ColumnDomain task);

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description elimina una columna
     * @param id identificador de la columna a eliminar
     * @return Column
     */
    public void delete(Integer id);

}
