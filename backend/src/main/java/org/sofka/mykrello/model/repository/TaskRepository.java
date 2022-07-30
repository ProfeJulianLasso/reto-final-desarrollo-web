package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.controller.domain.TaskDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskDomain, Integer> {

    /**
     * Selecciona las tareas  de un board en específico
     *
     * @param idBoard Objeto del contacto
     * @return Listado de tareas
     *
     * @author Jorge Montoya
     * @author Juan David Quimbayo
     */

    //SELECT * FROM krl_task  WHERE brd_id_board = 1;
    @Query(value = "SELECT task FROM TaskDomain task WHERE task.idBoard = :idBoard")
    public List<TaskDomain> findByIdBoard(@Param(value = "idBoard") Integer idBoard);
}
