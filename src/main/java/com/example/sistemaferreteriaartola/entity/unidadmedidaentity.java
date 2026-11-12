package com.example.sistemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "UnidadMedida")
public class unidadmedidaentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUnidadMedida")
    private Integer IdUnidadMedida;

    @Column(name = "Nombre", nullable = false, length = 50)
    private String Nombre;

    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaRegistro = new Date();
}