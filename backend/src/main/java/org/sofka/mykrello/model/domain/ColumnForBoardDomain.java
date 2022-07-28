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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

@Entity /**/ @Table(name = "krl_column_for_board")
@Getter /**/ @Setter

public class ColumnForBoardDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @PreUpdate
    public void preUpdate() {
        if (this.updatedAt == null)
            this.updatedAt = Instant.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cfb_id")
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BoardDomain.class, optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "brd_id_board")
    @JsonBackReference(value = "columnsForBoard")
    private BoardDomain board;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ColumnDomain.class, optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "clm_id_column")
    @JsonBackReference(value = "columnForBoards")
    private ColumnDomain column;


    @Column(name = "cfb_created_at", updatable = false)
    private Instant createdAt = Instant.now();


    @Column(name = "cfb_updated_at")
    private Instant updatedAt;

}
