package ar.edu.utn.tupad.sigcoin.domain.entities;

import ar.edu.utn.tupad.sigcoin.domain.enums.EstadoInmueble;
import ar.edu.utn.tupad.sigcoin.domain.enums.TipoInmueble;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "inmueble")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InmuebleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String localidad;
    @Column(nullable = false)
    private String provincia;
    @Column
    private String identificacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoInmueble tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoInmueble estado;
    @Column
    private String observaciones;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @PrePersist
    protected void onCreate() {
        this.creadoEn = LocalDateTime.now();
    }
}
