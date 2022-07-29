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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter @Setter //@Getter @Setter sirve para indicar que los atributos de la clase se pueden acceder desde fuera de la clase.
@Entity //@Entity sirve para indicar que la clase es una entidad.
@Table(name = "krl_board") //@Table sirve para indicar que la tabla se almacena en una tabla.
public class BoardDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @PreUpdate
    public void preUpdate() {
        if (this.updatedAt == null)
            this.updatedAt = Instant.now();
    }


    /**
     * @Id sirve para indicar que es la clave primaria de la tabla.
     * @GeneratedValue(strategy = GenerationType.IDENTITY) sirve para indicar que la clave primaria se genera automaticamente.
     * @Column(name = "brd_id", nullable = false) sirve para indicar que la clave primaria se almacena en una columna.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brd_id", nullable = false)
    private Integer id;


    /**
     * @Column sirve para indicar que la columna se almacena en una tabla.
     * @Column(name = "brd_name", nullable = false, length = 100) sirve para indicar que la columna se almacena en una tabla con un nombre y una longitud.
     */
    @Column(name = "brd_name", nullable = false, length = 100)
    private String name;


    /**
     * @Column(name = "brd_created_at", nullable = false, updatable = false) sirve para indicar que la columna se almacena en una tabla con un nombre y una fecha de creacion.
     */
    @Column(name = "brd_created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();


    /**
     * @Column(name = "brd_updated_at") sirve para indicar que la columna se almacena en una tabla con un nombre y una fecha de actualizacion.
     */
    @Column(name = "brd_updated_at")
    private Instant updatedAt;


    /**
     * @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY) sirve para indicar que la clase BoardDomain tiene una relacion con la clase CardDomain.
     * @JsonManagedReference sirve para indicar que la clase BoardDomain tiene una relacion con la clase CardDomain.
     */
    @OneToMany(fetch = FetchType.LAZY, targetEntity = ColumnForBoardDomain.class, cascade = CascadeType.ALL, mappedBy = "board")
    @JsonManagedReference(value = "columnsForBoard")
    private List<ColumnForBoardDomain> columnsForBoard = new ArrayList<>();


    /**
     * @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY) sirve para indicar que la clase BoardDomain tiene una relacion con la clase CardDomain.
     * @JsonManagedReference sirve para indicar que la clase BoardDomain tiene una relacion con la clase CardDomain.
     */
    @OneToMany(fetch = FetchType.EAGER, targetEntity = TaskDomain.class, cascade = CascadeType.ALL, mappedBy = "boardTask")
    @JsonManagedReference(value = "taskForBoard")
    private List<TaskDomain> task = new ArrayList<>();

}
