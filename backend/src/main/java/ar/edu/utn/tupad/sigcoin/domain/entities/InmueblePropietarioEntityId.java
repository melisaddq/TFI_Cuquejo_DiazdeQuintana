package ar.edu.utn.tupad.sigcoin.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InmueblePropietarioEntityId implements Serializable {

    @Column(name = "inmueble_id")
    private Long inmuebleId;

    @Column(name = "persona_id")
    private Long personaId;
}
