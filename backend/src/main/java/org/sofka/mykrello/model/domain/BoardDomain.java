package org.sofka.mykrello.model.domain;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;


@Entity /**/ @Table(name = "krl_board")
@Getter /**/ @Setter

public class BoardDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @PreUpdate
    public void preUpdate() {
        if (this.updatedAt == null)
            this.updatedAt = Instant.now();
    }

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brd_id")
    private Integer id;

    @Column(name = "brd_name", length = 100)
    private String name;

    @Column(name = "brd_created_at", updatable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "brd_updated_at")
    private Instant updatedAt;

    // Relaciones
    @OneToMany(fetch = FetchType.LAZY, targetEntity = ColumnForBoardDomain.class, cascade = CascadeType.ALL, mappedBy = "board")
    @JsonManagedReference(value = "columnsForBoard")
    private List<ColumnForBoardDomain> columnsForBoard = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, targetEntity = TaskDomain.class, cascade = CascadeType.ALL, mappedBy = "boardTask")
    @JsonManagedReference(value = "taskForBoard")
    private List<TaskDomain> task = new ArrayList<>();

}
