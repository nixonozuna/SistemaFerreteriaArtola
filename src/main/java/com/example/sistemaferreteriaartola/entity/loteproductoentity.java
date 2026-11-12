package com.example.sistemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "LoteProducto")
public class loteproductoentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLoteProducto")
    private Integer IdLoteProducto;

    @Column(name = "CodigoBarra", nullable = false, unique = true, length = 10)
    private String CodigoBarra;

    @ManyToOne
    @JoinColumn(name = "oUsuario", nullable = false)
    private usuarioentity usuario;

    @ManyToOne
    @JoinColumn(name = "oCompra", nullable = true) // Relación directa con la compra
    private compraentity compra;

    @ManyToOne
    @JoinColumn(name = "oProducto", nullable = false)
    private productoentity producto;

    @ManyToOne
    @JoinColumn(name = "oProveedor", nullable = false)
    private proveedorentity proveedor;

    @Column(name = "CantidadInicial", nullable = false)
    private Integer CantidadInicial = 0;

    @Column(name = "StockActual", nullable = false)
    private Integer StockActual = 0;

    @Column(name = "PrecioCompra", nullable = false, precision = 18, scale = 2)
    private BigDecimal PrecioCompra = BigDecimal.ZERO;

    @Column(name = "PrecioVenta", nullable = false, precision = 18, scale = 2)
    private BigDecimal PrecioVenta = BigDecimal.ZERO;

    @Column(name = "TieneVencimiento", nullable = false)
    private Boolean TieneVencimiento = false;

    @Column(name = "FechaVencimiento")
    @Temporal(TemporalType.DATE)
    private Date FechaVencimiento;

    @Column(name = "Estado", nullable = false)
    private Boolean Estado = true;

    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaIngreso = new Date();
}