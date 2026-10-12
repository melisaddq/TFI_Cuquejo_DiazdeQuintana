package ar.edu.utn.tupad.sigcoin.domain.entities;

import ar.edu.utn.tupad.sigcoin.domain.enums.EstadoSolicitudPago;
import ar.edu.utn.tupad.sigcoin.domain.enums.PrioridadSolicitud;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "solicitud_pago")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudPagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitante_id", nullable = false)
    private UsuarioEntity solicitante;
    @Column(nullable = false)
    private String concepto;
    @Column(nullable = false)
    private BigDecimal importe;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrioridadSolicitud prioridad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoSolicitudPago estado;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDateTime fechaSolicitud;

    // Quién aprobó o rechazó la solicitud, y cuándo (null mientras está PENDIENTE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resuelto_por")
    private UsuarioEntity resueltoPor;

    @Column(name = "fecha_resolucion")
    private LocalDateTime fechaResolucion;


    public void aprobar() {

    }

    public void rechazar() {

    }
}
