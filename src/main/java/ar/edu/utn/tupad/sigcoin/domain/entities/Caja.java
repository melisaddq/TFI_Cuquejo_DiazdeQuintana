package ar.edu.utn.tupad.sigcoin.domain.entities;

import ar.edu.utn.tupad.sigcoin.domain.enums.Moneda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "caja")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column private String nombre;
    @Column private String tipo; // enum?

    @Enumerated(EnumType.STRING)
    @Column private Moneda moneda;
    @Column private BigDecimal saldo;
    @Column private Boolean activa;

}
