package org.sofka.mykrello.model.service.interfaces;

import java.util.List;

import org.sofka.mykrello.controller.domain.TaskDomain;

/**
 * TaskServiceInterface es una interface que contiene
 * los metodos que se utilizan para el manejo de las tareas.
 */
public interface TaskServiceInterface {
    public List<TaskDomain> taskByIdBoard(Integer idBoard);
    public TaskDomain findById(Integer id);
    public TaskDomain create(TaskDomain task);
    public TaskDomain update(Integer id, TaskDomain task);
    public TaskDomain delete(Integer id);


}
