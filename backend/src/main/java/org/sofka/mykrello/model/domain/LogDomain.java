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

@Entity /**/ @Table(name = "krl_log")
@Getter /**/ @Setter

public class LogDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id", updatable = false)
    private Integer id;

    @Column(name = "tsk_id_task")
    private Integer taskId;

<<<<<<< HEAD
=======
   // @Column(name = "clm_id_previous")
   // private Integer columnaPrevious;

    //@Column(name = "clm_id_current")
    //private Integer columnaCurrent;

    @Column(name = "log_created_at", updatable = false)
    private Instant createdAt = Instant.now();

>>>>>>> main
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

    public LogDomain(Integer taskId, ColumnDomain previous, ColumnDomain current) {
        this.taskId = taskId;
        this.previous = previous;
        this.current = current;
    }

    public LogDomain() {
    }

}
