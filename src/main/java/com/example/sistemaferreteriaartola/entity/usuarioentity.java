package com.example.sistemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "Usuario")
public class usuarioentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private Integer IdUsuario;

    @ManyToOne
    @JoinColumn(name = "oRol", nullable = false)
    private rolentity rol;

    @Column(name = "Nombres", nullable = false, length = 50)
    private String Nombres;

    @Column(name = "Apellidos", nullable = false, length = 50)
    private String Apellidos;

    @Column(name = "Sexo", nullable = false, length = 10)
    private String Sexo;

    @Column(name = "FechaNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date FechaNacimiento;

    @Column(name = "Telefono", nullable = false, length = 9)
    private String Telefono;

    @Column(name = "Cedula", nullable = false, unique = true, length = 16)
    private String Cedula;

    @Column(name = "Direccion", nullable = false, length = 100)
    private String Direccion;

    @Column(name = "NombreUsuario", nullable = false, unique = true, length = 30)
    private String NombreUsuario;

    @Column(name = "ContraseñaUsuario", nullable = false, length = 10)
    private String ContraseñaUsuario;

    @Column(name = "Estado", nullable = false)
    private Boolean Estado = true;

    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaRegistro = new Date();
}