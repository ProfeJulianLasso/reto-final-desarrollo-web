package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.controller.domain.LogDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


/**
 * La interface LogRepository es una interfaz que
 * extiende de JpaRepository y se encarga de realizar las operaciones
 * CRUD sobre la tabla krl_log.
 */
public interface LogRepository extends JpaRepository<LogDomain, Integer>{ }
