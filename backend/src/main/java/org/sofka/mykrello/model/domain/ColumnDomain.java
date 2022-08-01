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

/***
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description aqui se mapean los datos de la tabla "krl_column" y las relaciones entre tablas
 * @Params None
 * @Anotations Entity - Table - Getter - Setter
 */
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

    /***
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description atributos del objeto Column
     * @Anotations Id - GeneratedValue - Column
     */
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

    /***
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description mapeo de relaciones - una columna muchos Logs & una columna muchas columnas para tablero-
     * @Anotations OneToMany - JsonManagedReference
     */
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
