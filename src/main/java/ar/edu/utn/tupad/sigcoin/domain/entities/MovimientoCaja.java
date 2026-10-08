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

    @ManyToOne
    @JoinColumn(name = "caja_id")
    private Caja caja;

    @ManyToOne @JoinColumn(name = "cobranza_id")
    private Cobranza cobranza;

    @ManyToOne @JoinColumn(name = "solicitud_pago_id")
    private SolicitudPago solicitudPago;

    @ManyToOne @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column private TipoMovimiento tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "medio_de_pago")
    private MedioDePago medioDePago;

    @Column private String concepto;
    @Column private BigDecimal importe;

    @Column (name = "fecha_hora")
    private LocalDateTime fechaHora;




}
