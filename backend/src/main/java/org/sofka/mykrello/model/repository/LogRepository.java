package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.controller.domain.LogDomain;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * La interface LogRepository es una interfaz que
 * extiende de JpaRepository y se encarga de realizar las operaciones
 * CRUD sobre la tabla krl_log.
 */
public interface LogRepository extends JpaRepository<LogDomain, Integer>{
/*
    @Query(value = "SELECT log " +
            "FROM log  " +
            "WHERE  krl_log.tsk_id_task = :task")
    public List<LogDomain> findByTask(@Param(value = "task") Integer task);
*/

}
