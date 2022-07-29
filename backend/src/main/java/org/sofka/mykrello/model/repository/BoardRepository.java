package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.BoardDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * La clase BoardRepository es la encargada de realizar
 * las operaciones de CRUD de la entidad Board.
 */
public interface BoardRepository extends JpaRepository<BoardDomain, Integer> { }
