package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.BoardDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @Author [Julian Lasso]
 * @Description La interfaz BoardRepository enviar los metodos de la interfaz padre JpaRepository la cual ayuda agiliza el proceso basico de un CRUD
 * @Params <BoardDomain> <- El dominio de la interfaz
 * @Params <Integer> <- El tipo de dato para el identificador principal del dominio
 */

public interface BoardRepository extends JpaRepository<BoardDomain, Integer> { }
