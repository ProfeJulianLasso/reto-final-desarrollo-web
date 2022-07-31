package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.TaskDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @Author [Julian Lasso]
 * @Description La interfaz TaskRepository enviar los metodos de la interfaz padre JpaRepository la cual ayuda agiliza el proceso basico de un CRUD
 * @Params <TaskDomain> <- El dominio de la interfaz
 * @Params <Integer> <- El tipo de dato para el identificador principal del dominio
 */

public interface TaskRepository extends JpaRepository<TaskDomain, Integer> { }
