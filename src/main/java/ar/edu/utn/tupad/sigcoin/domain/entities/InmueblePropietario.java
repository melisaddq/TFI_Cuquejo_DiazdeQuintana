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

    @ManyToOne @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;

    @ManyToOne @JoinColumn(name = "persona_id")
    private Persona persona;

    @Column private BigDecimal porcentaje;
}
