package ar.edu.utn.tupad.sigcoin.domain.entities;


import ar.edu.utn.tupad.sigcoin.domain.enums.EstadoComprobante;
import ar.edu.utn.tupad.sigcoin.domain.enums.TipoComprobante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comprobante",
        uniqueConstraints = @UniqueConstraint(columnNames = {"tipo", "punto_venta", "numero"}))
public class ComprobanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cobranza_id", nullable = false)
    private CobranzaEntity cobranzaEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emitido_por", nullable = false)
    private UsuarioEntity emitidoPor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoComprobante tipo;

    @Column(name = "punto_venta", nullable = false)
    private Integer puntoVenta;

    @Column(nullable = false)
    private Integer numero;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "importe_total", nullable = false)
    private BigDecimal importeTotal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoComprobante estado;

    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    public void anular(String motivo) {
    }
}
