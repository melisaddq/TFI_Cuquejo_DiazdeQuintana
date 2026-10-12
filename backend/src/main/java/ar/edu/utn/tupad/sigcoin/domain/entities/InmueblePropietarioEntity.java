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
public class InmueblePropietarioEntity {

    @EmbeddedId
    private InmueblePropietarioEntityId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("inmuebleId")
    @JoinColumn(name = "inmueble_id")
    private InmuebleEntity inmuebleEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personaId")
    @JoinColumn(name = "persona_id")
    private PersonaEntity personaEntity;

    @Column(nullable = false)
    private BigDecimal porcentaje;
}
