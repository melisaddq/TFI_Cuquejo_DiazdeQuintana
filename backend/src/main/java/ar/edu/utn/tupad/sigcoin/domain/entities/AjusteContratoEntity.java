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
public class AjusteContratoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrato_id", nullable = false)
    private ContratoEntity contratoEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indice_id")
    private IndiceEntity indiceEntity;

    @Column(name = "fecha_aplicacion", nullable = false)
    private LocalDate fechaAplicacion;

    @Column(name = "importe_anterior", nullable = false)
    private BigDecimal importeAnterior;
    @Column(nullable = false)
    private BigDecimal porcentaje;
    @Column(nullable = false)
    private BigDecimal nuevoImporte;
}
