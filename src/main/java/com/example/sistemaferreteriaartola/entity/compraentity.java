package com.example.sistemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "Compra")
public class compraentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCompra")
    private Integer IdCompra;

    @ManyToOne
    @JoinColumn(name = "oUsuario", nullable = false)
    private usuarioentity usuario;

    @ManyToOne
    @JoinColumn(name = "oProveedor", nullable = false)
    private proveedorentity proveedor;

    @Column(name = "NumeroFactura", nullable = false, length = 50)
    private String NumeroFactura;

    @Column(name = "TipoDocumento", nullable = false, length = 50)
    private String TipoDocumento;

    @Column(name = "FormaPago", nullable = false, length = 50)
    private String FormaPago;

    @Column(name = "Moneda", nullable = false)
    private Boolean Moneda = true; // true = Córdoba / false = Dólar

    @Column(name = "DescuentoGlobal", precision = 18, scale = 2)
    private BigDecimal DescuentoGlobal = BigDecimal.ZERO;

    @Column(name = "TotalInicial", nullable = false, precision = 18, scale = 2)
    private BigDecimal TotalInicial = BigDecimal.ZERO;

    @Column(name = "TotalFinal", nullable = false, precision = 18, scale = 2)
    private BigDecimal TotalFinal = BigDecimal.ZERO;

    @Column(name = "MontoPagado", nullable = false, precision = 18, scale = 2)
    private BigDecimal MontoPagado = BigDecimal.ZERO;

    @Column(name = "Cambio", nullable = false, precision = 18, scale = 2)
    private BigDecimal Cambio = BigDecimal.ZERO;

    @Column(name = "Estado", nullable = false)
    private Boolean Estado = true;

    @Column(name = "FechaCompra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaCompra = new Date();
}