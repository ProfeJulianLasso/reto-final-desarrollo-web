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
public class TaskDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tsk_id", nullable = false)
    private Integer id;

    @ManyToOne(/*fetch = FetchType.LAZY,*/ targetEntity = ColumnDomain.class, optional = false, cascade = CascadeType.DETACH,fetch = FetchType.EAGER) // refe
    //@JsonBackReference(value = "taskForColumn") // back si estas en many
    @JsonManagedReference(value = "taskForColumn")
    @JsonIgnore
    @JoinColumn( name = "clm_id_column",insertable =false, updatable=false ) // column foranea
    private ColumnDomain columnTask; // tipo de clase dentro de springboot

    @ManyToOne(/*fetch = FetchType.LAZY,*/targetEntity = BoardDomain.class, optional = false, cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    //@JsonBackReference(value = "taskForBoard")
    @JsonManagedReference(value = "taskForBoard")
    @JsonIgnore
    @JoinColumn( name = "brd_id_board", insertable =false, updatable=false)
    private BoardDomain boardTask;


    @Column( name = "clm_id_column",insertable =true, updatable=true)
    private Integer idColumn;

    @Column( name = "brd_id_board", insertable =true, updatable=true)
    private Integer idBoard;


    @Column( name = "tsk_name", nullable = false)
    private String name;

    @Column(name = "tsk_description", nullable = false)
    private String description;

    @Column(name="tsk_delivery_date")
    private Date deliveryDate;

    @Column(name="tsk_created_at")
    private Instant create;

    @Column(name="tsk_updated_at")
    private Date updated;

}