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
@Table(name = "solicitud_pago" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne @JoinColumn(name = "solicitante_id")
    private Usuario solicitanteId;
    @Column private String concepto;
    @Column private BigDecimal importe;

    @Enumerated(EnumType.STRING)
    @Column private PrioridadSolicitud prioridad;

    @Enumerated(EnumType.STRING)
    @Column private EstadoSolicitudPago estado;

    @Column (name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud;


    public void aprobar(){

    }
    public void rechazar(){

    }
}
