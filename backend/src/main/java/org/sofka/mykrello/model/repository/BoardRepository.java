package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.controller.domain.BoardDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * La interfaz BoardRepository es una interfaz que
 * extiende de JpaRepository y se encarga de realizar las operaciones
 * CRUD sobre la tabla krl_board.
 */
public interface BoardRepository extends JpaRepository<BoardDomain, Integer> { }
