package ar.edu.utn.tupad.sigcoin.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "inmueble_propietario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InmueblePropietario {

    @EmbeddedId
    private InmueblePropietarioId id;

    @ManyToOne(fetch = FetchType.LAZY) @MapsId("inmuebleId")
    @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;

    @ManyToOne(fetch = FetchType.LAZY) @MapsId("personaId")
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @Column(nullable = false) private BigDecimal porcentaje;
}
