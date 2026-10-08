package ar.edu.utn.tupad.sigcoin.domain.entities;

import ar.edu.utn.tupad.sigcoin.domain.enums.EstadoContrato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "contrato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;

    @ManyToMany
    @JoinTable(name = "contrato_inquilino", joinColumns = @JoinColumn(name = "contrato_id"), inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private List<Persona> inquilinos;

    @ManyToMany
    @JoinTable(name = "contrato_garante", joinColumns = @JoinColumn(name = "contrato_id"), inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private List<Persona> garantes;

    @Column (name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column (name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "importe_inicial")
    private BigDecimal importeInicial;

    @Column (name = "importe_venta")
    private BigDecimal importeVigente;

    @Column (name = "periodicidad_meses")
    private Integer periodicidadMeses;

    @Column (name = "tipo_indice")
    private String tipoIndice;

    @Enumerated(EnumType.STRING)
    @Column private EstadoContrato estado;

    @Column (name = "creado_en")
    private LocalDateTime creadoEn;

    public BigDecimal calcularNuevoImporte(BigDecimal porcentajeAjuste) {
        // 1. Convertimos el porcentaje a decimal (ej: 150% pasa a ser 1.50)
        // Es recomendable usar String ("100") en BigDecimal para evitar pérdida de precisión
        BigDecimal factorDecimal = porcentajeAjuste.divide(new BigDecimal("100"));

        // 2. Calculamos el monto de aumento multiplicando el importe vigente por el factor
        BigDecimal montoAumento = this.importeVigente.multiply(factorDecimal);

        // 3. Retornamos la suma del importe actual más el aumento calculado
        return this.importeVigente.add(montoAumento);
    }
    // Actualizamos importeVigente

//    public void aplicarAjuste(BigDecimal porcentajeAjuste) {
//        this.importeVigente = calcularNuevoImporte(porcentajeAjuste);
//    }
}
