package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.ColumnDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @Author [Julian Lasso]
 * @Description La interfaz ColumnRepository enviar los metodos de la interfaz padre JpaRepository la cual ayuda agiliza el proceso basico de un CRUD
 * @Params <ColumnDomain> <- El dominio de la interfaz
 * @Params <Integer> <- El tipo de dato para el identificador principal del dominio
 */

public interface ColumnRepository extends JpaRepository<ColumnDomain, Integer> { }
