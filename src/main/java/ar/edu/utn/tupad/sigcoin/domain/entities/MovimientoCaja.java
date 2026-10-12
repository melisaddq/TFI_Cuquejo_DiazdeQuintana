package ar.edu.utn.tupad.sigcoin.domain.entities;

import ar.edu.utn.tupad.sigcoin.domain.enums.MedioDePago;
import ar.edu.utn.tupad.sigcoin.domain.enums.TipoMovimiento;
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
@Table(name = "movimiento_caja" )
public class MovimientoCaja {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caja_id", nullable = false)
    private Caja caja;

    // Un movimiento se origina en una cobranza o en una solicitud de pago (o en ninguna, si es manual)
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "cobranza_id")
    private Cobranza cobranza;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "solicitud_pago_id")
    private SolicitudPago solicitudPago;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) private TipoMovimiento tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "medio_de_pago", nullable = false)
    private MedioDePago medioDePago;

    @Column(nullable = false) private String concepto;
    @Column(nullable = false) private BigDecimal importe;

    @Column (name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

}
