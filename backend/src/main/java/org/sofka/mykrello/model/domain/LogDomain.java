package org.sofka.mykrello.model.domain;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

/***
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description aqui se mapean los datos de la tabla "krl_log" y las relaciones entre tablas
 * @Params None
 * @Anotations Entity - Table - Getter - Setter
 */
@Entity /**/ @Table(name = "krl_log")
@Getter /**/ @Setter

public class LogDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /***
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description atributos del objeto Log
     * @Anotations Id - GeneratedValue - Column
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id", updatable = false)
    private Integer id;

    @Column(name = "tsk_id_task")
    private Integer taskId;

    // @Column(name = "clm_id_previous")
    // private Integer columnaPrevious;

    //@Column(name = "clm_id_current")
    //private Integer columnaCurrent;

    @Column(name = "log_created_at", updatable = false)
    private Instant createdAt = Instant.now();

    /***
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description mapeo de relaciones - muchos Logs pertenecen a una columna & muchos Logs pertenecen a una tarea-
     * @Anotations OneToMany - JsonBackReference - JoinColumn
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ColumnDomain.class, optional = false)
    @JoinColumn(name = "clm_id_previous", updatable = false)
    @JsonBackReference(value = "logPrevious")
    private ColumnDomain previous;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ColumnDomain.class, optional = false)
    @JoinColumn(name = "clm_id_current", updatable = false)
    @JsonBackReference(value = "logCurrent")
    private ColumnDomain current;

    @JoinColumn(name = "tsk_id_task", insertable = false, updatable = false)
    @JsonBackReference(value = "log-task")
    @ManyToOne(fetch = FetchType.LAZY)
    private TaskDomain task;

    /**
     * LogDomain es el constructor por defecto.
     * @param taskId SIRVE PARA HACER UN JOIN CON LA TABLA TASK
     * @param previous
     * @param current
     */

    public LogDomain(Integer taskId, ColumnDomain previous, ColumnDomain current) {
        this.taskId = taskId;
        this.previous = previous;
        this.current = current;
    }

    public LogDomain() {
    }

}