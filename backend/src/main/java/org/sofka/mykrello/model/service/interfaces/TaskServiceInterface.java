package org.sofka.mykrello.model.service.interfaces;

import java.util.List;

import org.sofka.mykrello.model.domain.TaskDomain;

/**
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description interfaz de servicio del dominio Task
 */
public interface TaskServiceInterface {

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve el listado de tareas existentes
     * @return Listado de Tareas
     */
    public List<TaskDomain> findAll();

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Busca una Task de acuerdo al identificador
     * @param id Identificador de la Task
     * @return Task
     */
    public TaskDomain findById(Integer id);

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Crea una Task
     * @param task datos de la Task para crear
     * @return Task
     */
    public TaskDomain create(TaskDomain task);

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Actualiza una Task
     * @param task datos de la Task para actualizar
     * @return Task
     */
    public TaskDomain update(TaskDomain task);
    public void delete(Integer id);
}
