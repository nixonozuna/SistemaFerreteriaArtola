package com.example.sistemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "Rol")
public class rolentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRol", columnDefinition = "INT")
    private Integer IdRol;

    @Column(name = "Descripcion", nullable = false, length = 50)
    private String Descripcion;

    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaRegistro = new Date();
}