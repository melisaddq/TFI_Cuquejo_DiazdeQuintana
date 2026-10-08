package ar.edu.utn.tupad.sigcoin.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ajuste_contrato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AjusteContrato {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    @ManyToOne @JoinColumn(name = "indice_id")
    private Indice indice;

    @Column(name = "fecha_aplicacion")
    private LocalDate fechaAplicacion;

    @Column (name = "importe_anterior" )
    private BigDecimal importeAnterior;
    @Column private BigDecimal porcentaje;
    @Column private BigDecimal nuevoImporte;
}
