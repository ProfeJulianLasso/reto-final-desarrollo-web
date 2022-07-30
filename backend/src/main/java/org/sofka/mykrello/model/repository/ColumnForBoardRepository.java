package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.controller.domain.ColumnForBoardDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * La interfaz ColumnForBoardRepository es una interfaz que
 * extiende de JpaRepository y se encarga de realizar las operaciones
 * CRUD sobre la tabla krl_column_for_board.
 */
public interface ColumnForBoardRepository extends JpaRepository<ColumnForBoardDomain, Integer> { }
