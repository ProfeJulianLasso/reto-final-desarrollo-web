package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.LogDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LogRepository extends JpaRepository<LogDomain, Integer>{
/*
    @Query(value = "SELECT log " +
            "FROM log  " +
            "WHERE  krl_log.tsk_id_task = :task")
    public List<LogDomain> findByTask(@Param(value = "task") Integer task);

/*/

}
