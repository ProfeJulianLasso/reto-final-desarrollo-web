package org.sofka.mykrello.model.domain;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
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

/***
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description aqui se mapean los datos de la tabla "krl_column_for_board" y las relaciones entre tablas
 * @Params None
 * @Anotations Entity - Table - Getter - Setter
 */
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

    /***
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description atributos del objeto ColumnForBoard
     * @Anotations Id - GeneratedValue - Column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cfb_id")
    private Integer id;

    @Column(name = "cfb_created_at", updatable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "cfb_updated_at")
    private Instant updatedAt;

    /***
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description mapeo de relaciones - muchas Columnas para tablero pertenecen a un tablero & muchas columnas para tablero pertenecen a una columna -
     * @Anotations ManyToOne - JsonBackReference - JoinColumn
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BoardDomain.class, optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "brd_id_board")
    @JsonBackReference(value = "columnsForBoard")
    private BoardDomain board;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ColumnDomain.class, optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "clm_id_column")
    @JsonBackReference(value = "columnForBoards")
    private ColumnDomain column;


}
