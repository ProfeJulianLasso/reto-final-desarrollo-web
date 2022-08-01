package org.sofka.mykrello.model.service;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.repository.BoardRepository;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.service.interfaces.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description Clase tipo Servicio para el manejo de Task
 * @Anotation Service
 */
@Service
public class TaskService implements TaskServiceInterface {

    Logger log = Logger.getLogger("Logger");

    /**
     * Repositorio de Task
     */
    @Autowired
    private TaskRepository taskRepository;

    /**
     * Servicio de Log
     */
    @Autowired
    private LogService logService;

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve una lista de Task
     * @return listado de Task
     ** @Anotation Override
     */
    @Override
    public List<TaskDomain> findAll() {
        return taskRepository.findAll();
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve un Task de acuerdo al id
     * @param id Identificador del Task
     * @return Task
     ** @Anotation Override
     */
    @Override
    public TaskDomain findById(Integer id) {
        Optional<TaskDomain> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Crea un Task de acuerdo a la informacion entregada
     * @param task Informacion del Task
     * @return Task
     ** @Anotation Override
     */
    @Override
    public TaskDomain create(TaskDomain task) {
        return taskRepository.save(task);
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Actualiza un Task de acuerdo a la informacion entregada
     * @param task Informacion del tablero
     * @return Task
     ** @Anotation Override
     */
    @Override
    public TaskDomain update(TaskDomain task) {
        return taskRepository.save(task);
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description elimina un Task de acuerdo al id
     * @param id identificacion del tablero
     * @return Task
     ** @Anotation Override
     */
    @Override
    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }

}
