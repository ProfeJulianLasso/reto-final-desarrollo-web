package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.controller.domain.ColumnDomain;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * La interfaz ColumnRepository es una interfaz que
 * extiende de JpaRepository y se encarga de realizar las operaciones
 * CRUD sobre la tabla krl_column.
 */
public interface ColumnRepository extends JpaRepository<ColumnDomain, Integer> { }
