package org.sofka.mykrello.controller.domain.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data //@Data esta aotacion sirve para generar los getters y setters automaticamente
@Entity //@Entity indica que esta clase es una entidad
@Table(name = "krl_column") //@Table indica que la tabla que se va a mapear es la tabla krl_column
public class ColumnOutDomain implements Serializable {

    /**
     *serialVersionUID es una clave que sirve para serializar la clase
     */
    private static final long serialVersionUID = 1L;


    /**
     * @Id indica que ese campo es la llave primaria
     * @GeneratedValue indica que el valor de la llave primaria es autoincrementable
     * @Column indica que el campo es una columna de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clm_id")
    private Integer id;

    /**
     * @Column indica que el campo es una columna de la tabla
     */
    @Column(name = "clm_name",  length = 100)
    private String name;

}
