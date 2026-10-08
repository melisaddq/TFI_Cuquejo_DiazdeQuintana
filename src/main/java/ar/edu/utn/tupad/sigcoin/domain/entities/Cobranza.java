package ar.edu.utn.tupad.sigcoin.domain.entities;

import ar.edu.utn.tupad.sigcoin.domain.enums.EstadoCobranza;
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

    @ManyToOne @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    @ManyToOne @JoinColumn(name = "registrado_por")
    private Usuario registradoPor;

    @Column private LocalDate periodo;

    @Column (name = "fecha_pago")
    private LocalDate fechaPago;
    @Column private BigDecimal importe;

    @Column (name = "medio_pago")
    private String medioPago;

    @Enumerated(EnumType.STRING)
    @Column private EstadoCobranza estado;



    public void registrarPago(){

    }

}
