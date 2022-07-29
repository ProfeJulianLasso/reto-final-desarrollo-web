package org.sofka.mykrello.model.domain;

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

import lombok.Data;

@Data
@Entity
/**
 * clase que permite representar ka entidad de base de datos llamada Log y poder mapiar sus columnas en los
 * atributos de la clase.
 * @author Jorge Montoya
 * @author Juan David Quimbayo
 * @version 1
 */
@Table(name = "krl_log")
public class LogDomain implements Serializable {

    /**
     * variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */

    private static final long serialVersionUID = 1L;
    /**
     * representa la columna del Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id", nullable = false, updatable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ColumnDomain.class, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "clm_id_previous", nullable = false, updatable = false, insertable = false)
    @JsonBackReference(value = "logPrevious")
    private ColumnDomain previous;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ColumnDomain.class, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "clm_id_current", nullable = false, updatable = false, insertable = false)
    @JsonBackReference(value = "logCurrent")
    private ColumnDomain current;

    /**
     * fecha y hora de creacion
     */
    @Column(name = "log_created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    /**
     * id correspondiente  a la tarea
     */
    @Column(name = "tsk_id_task", nullable = false, updatable = false)
    private String idTask;

    /**
     *  id coorespondiente del previus
     */
    @Column(name = "clm_id_previous", nullable = false, updatable = false)
    private String idPrevious;

    /**
     * id correspondiente del current
     */
    @Column(name = "clm_id_current", nullable = false, updatable = false)
    private String idCurrent;




}
