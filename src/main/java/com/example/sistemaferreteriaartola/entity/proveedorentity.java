package com.example.sistemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "Proveedor")
public class proveedorentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProveedor")
    private Integer IdProveedor;

    @Column(name = "RazonSocial", nullable = false, length = 50)
    private String RazonSocial;

    @Column(name = "Email", length = 100)
    private String Email;

    @Column(name = "Telefono", nullable = false, length = 9)
    private String Telefono;

    @Column(name = "Direccion", length = 100)
    private String Direccion;

    @Column(name = "Estado", nullable = false)
    private Boolean Estado = true;

    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaRegistro = new Date();
}