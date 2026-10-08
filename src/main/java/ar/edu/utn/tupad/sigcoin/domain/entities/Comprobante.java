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
@Table(name = "comprobante")
public class Comprobante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne @JoinColumn(name = "cobranza_id")
    private Cobranza cobranza;

    @ManyToOne @JoinColumn(name = "emitido_por")
    private Usuario emitidoPor;

    @Enumerated(EnumType.STRING)
    @Column private TipoComprobante tipo;

    @Column (name = "punto_venta")
    private Integer puntoVenta;

    @Column private Integer numero;

    @Column (name = "fecha_emision")
    private LocalDateTime fechaEmision;

    @Column (name = "importe_total")
    private BigDecimal importeTotal;

    @Enumerated(EnumType.STRING)
    @Column private EstadoComprobante estado;

    @Column (name = "motivo_anulacion")
    private String motivoAnulacion;

    public void anular(String motivo) {
    }
}
