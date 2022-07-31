package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.controller.domain.LogDomain;
import org.sofka.mykrello.controller.domain.TaskDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.data.repository.query.Param;

import java.util.List;
=======

import java.util.Optional;
>>>>>>> 56b5f81bf9da1c914458f1b01978c2a4d8ae7d62


/**
 * La interface LogRepository es una interfaz que
 * extiende de JpaRepository y se encarga de realizar las operaciones
 * CRUD sobre la tabla krl_log.
 */
<<<<<<< HEAD
public interface LogRepository extends JpaRepository<LogDomain, Integer>{

    @Query(value = "SELECT task FROM LogDomain task WHERE task.idTask = :idTask")
    public List<LogDomain> findByIdLogbytask(@Param(value = "idTask") String idTask);

}
=======
public interface LogRepository extends JpaRepository<LogDomain, Integer>{ }
>>>>>>> 56b5f81bf9da1c914458f1b01978c2a4d8ae7d62
