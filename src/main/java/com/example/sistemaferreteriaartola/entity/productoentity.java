package com.example.sistemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "Producto")
public class productoentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProducto")
    private Integer IdProducto;

    @Column(name = "CodigoBarra", nullable = false, unique = true, length = 10)
    private String CodigoBarra;

    @ManyToOne
    @JoinColumn(name = "oCategoriaProducto", nullable = false)
    private categoriaproductoentity categoriaProducto;

    @ManyToOne
    @JoinColumn(name = "oUnidadMedida")
    private unidadmedidaentity unidadMedida;

    @Column(name = "Nombre", nullable = false, length = 50)
    private String Nombre;

    @Column(name = "Descripcion", length = 100)
    private String Descripcion;

    @Column(name = "Stock", nullable = false)
    private Integer Stock = 0;

    @Column(name = "Estado", nullable = false)
    private Boolean Estado = true;

    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaRegistro = new Date();
}