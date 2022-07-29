package org.sofka.mykrello.model.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Value;

@Data
@Entity
@Table(name = "krl_task")

/**
 * Clase que permite representar las tablas como clases; ademas de indicar las relaciones entre ellas.
 * @author Jorge Montoya
 * @author Juan David Quimbayo
 * @version 1.0
 */
public class TaskDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * columna que representa el Id de la tabla task llamado tsk_id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tsk_id", nullable = false)
    private Integer id;

    /**
     * se indica una relacion de muchas tareas a una columna
     */
    @ManyToOne(targetEntity = ColumnDomain.class, optional = false, cascade = CascadeType.DETACH,fetch = FetchType.EAGER) // refe
    @JsonManagedReference(value = "taskForColumn")
    @JsonIgnore
    @JoinColumn( name = "clm_id_column",insertable =false, updatable=false ) // column foranea
    private ColumnDomain columnTask; // tipo de clase dentro de springboot

    /**
     * se indica la relacion de muchas tareas a un Tablero
     */
    @ManyToOne(targetEntity = BoardDomain.class, optional = false, cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JsonManagedReference(value = "taskForBoard")
    @JsonIgnore
    @JoinColumn( name = "brd_id_board", insertable =false, updatable=false)
    private BoardDomain boardTask;

    /**
     * representa la  el id de la columna clm_id_column de la tabla Task
     */
    @Column( name = "clm_id_column",insertable =true, updatable=true)
    private Integer idColumn;

    /**
     * representa la columna de la tabla task llamada  brd_id_board
     */
    @Column( name = "brd_id_board", insertable =true, updatable=true)
    private Integer idBoard;

    /**
     * representa la columna correspondinte a los nombres de la tabla task
     */
    @Column( name = "tsk_name", nullable = false)
    private String name;


    /**
     * representa la columna correspondinte a la descripcion de la tabla task
     */
    @Column( name = "tsk_description", nullable = false)
    private String description;

    /**
     * representa la columna correspondinte a la fecha de creacion de la tabla task
     */
    @Column(name="tsk_delivery_date")
    private Date deliveryDate;

    /**
     * representa la columna correspondinte a la fecha de creacion de la tabla task
     */
    @Column(name="tsk_created_at")
    private Instant create;

    /**
     * representa la columna correspondinte a la fecha de actualizacion de la tabla task
     */
    @Column(name="tsk_updated_at")
    private Date updated;

}
