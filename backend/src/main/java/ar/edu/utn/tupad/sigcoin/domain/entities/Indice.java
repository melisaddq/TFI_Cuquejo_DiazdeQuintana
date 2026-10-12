package ar.edu.utn.tupad.sigcoin.domain.entities;

import ar.edu.utn.tupad.sigcoin.domain.enums.TipoIndice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "indice",
        uniqueConstraints = @UniqueConstraint(columnNames = {"tipo", "periodo"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Indice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) private TipoIndice tipo;
    @Column(nullable = false) private LocalDate periodo;
    @Column(nullable = false) private BigDecimal valor;
    @Column private String fuente;

    @Column (name = "consultado_en")
    private LocalDateTime consultadoEn;
}
