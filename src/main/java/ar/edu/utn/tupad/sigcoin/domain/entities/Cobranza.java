package ar.edu.utn.tupad.sigcoin.domain.entities;

import ar.edu.utn.tupad.sigcoin.domain.enums.EstadoCobranza;
import ar.edu.utn.tupad.sigcoin.domain.enums.MedioDePago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cobranza")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cobranza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "contrato_id", nullable = false)
    private Contrato contrato;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "registrado_por")
    private Usuario registradoPor;

    @Column(nullable = false) private LocalDate periodo;

    // fechaPago y medioPago quedan en null mientras la cobranza está PENDIENTE
    @Column (name = "fecha_pago")
    private LocalDate fechaPago;
    @Column(nullable = false) private BigDecimal importe;

    @Enumerated(EnumType.STRING)
    @Column (name = "medio_pago")
    private MedioDePago medioPago;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) private EstadoCobranza estado;



    public void registrarPago(){

    }

}
