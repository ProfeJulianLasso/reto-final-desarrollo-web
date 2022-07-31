package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.LogDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @Author [Julian Lasso]
 * @Description La interfaz LogRepository enviar los metodos de la interfaz padre JpaRepository la cual ayuda agiliza el proceso basico de un CRUD
 * @Params <LogDomain> <- El dominio de la interfaz
 * @Params <Integer> <- El tipo de dato para el identificador principal del dominio
 */

public interface LogRepository extends JpaRepository<LogDomain, Integer>{ }
