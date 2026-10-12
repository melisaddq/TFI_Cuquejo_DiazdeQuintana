package ar.edu.utn.tupad.sigcoin.domain.entities;

import ar.edu.utn.tupad.sigcoin.domain.enums.EstadoContrato;
import ar.edu.utn.tupad.sigcoin.domain.enums.TipoIndice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "contrato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inmueble_id", nullable = false)
    private InmuebleEntity inmuebleEntity;

    @ManyToMany
    @JoinTable(name = "contrato_inquilino", joinColumns = @JoinColumn(name = "contrato_id"), inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private Set<PersonaEntity> inquilinos;

    @ManyToMany
    @JoinTable(name = "contrato_garante", joinColumns = @JoinColumn(name = "contrato_id"), inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private Set<PersonaEntity> garantes;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "importe_inicial", nullable = false)
    private BigDecimal importeInicial;

    @Column(name = "importe_vigente", nullable = false)
    private BigDecimal importeVigente;

    @Column(name = "periodicidad_meses", nullable = false)
    private Integer periodicidadMeses;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_indice", nullable = false)
    private TipoIndice tipoIndice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoContrato estado;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @PrePersist
    protected void onCreate() {
        this.creadoEn = LocalDateTime.now();
    }


    // Todo
    public BigDecimal calcularNuevoImporte(BigDecimal porcentajeAjuste) {
        // 1. Convertimos el porcentaje a decimal (ej: 150% pasa a ser 1.50)
        // Es recomendable usar String ("100") en BigDecimal para evitar pérdida de precisión
        BigDecimal factorDecimal = porcentajeAjuste.divide(new BigDecimal("100"));

        // 2. Calculamos el monto de aumento multiplicando el importe vigente por el factor
        BigDecimal montoAumento = this.importeVigente.multiply(factorDecimal);

        // 3. Retornamos la suma del importe actual más el aumento calculado, redondeada a centavos
        return this.importeVigente.add(montoAumento).setScale(2, RoundingMode.HALF_UP);
    }
    // Actualizamos importeVigente

    public void aplicarAjuste(BigDecimal porcentajeAjuste) {
        this.importeVigente = calcularNuevoImporte(porcentajeAjuste);
    }
}
