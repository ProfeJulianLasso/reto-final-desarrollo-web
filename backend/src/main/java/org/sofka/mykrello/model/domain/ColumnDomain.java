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
import lombok.*;

@Entity /**/ @Table(name = "krl_column")
@Setter /**/ @Getter

public class ColumnDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @PreUpdate
    public void preUpdate() {
        if (this.updatedAt == null)
            this.updatedAt = Instant.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clm_id")
    private Integer id;

    @Column(name = "clm_name", length = 100)
    private String name;

    @Column(name = "clm_created_at", updatable = false)
    private Instant createdAt = Instant.now();
    @Column(name = "clm_updated_at")
    private Instant updatedAt;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = LogDomain.class, mappedBy = "previous")
    @JsonManagedReference(value = "logPrevious")
    private List<LogDomain> logPrevious = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, targetEntity = LogDomain.class, mappedBy = "current")
    @JsonManagedReference(value = "logCurrent")
    private List<LogDomain> logCurrent = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ColumnForBoardDomain.class, cascade = CascadeType.ALL, mappedBy = "column")
    @JsonManagedReference(value = "columnForBoards")
    private List<ColumnForBoardDomain> columnForBoards = new ArrayList<>();

}
