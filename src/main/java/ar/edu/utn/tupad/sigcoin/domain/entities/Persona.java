package ar.edu.utn.tupad.sigcoin.domain.entities;

import ar.edu.utn.tupad.sigcoin.domain.enums.TipoDocumento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "persona",
        uniqueConstraints = @UniqueConstraint(columnNames = {"tipo_documento", "numero_documento"}))
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column (name = "tipo_documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column (name = "numero_documento", nullable = false)
    private String numeroDocumento;
    @Column(unique = true) private String cuit;
    @Column(nullable = false) private String nombre;
    @Column(nullable = false) private String apellido;
    @Column private String email;
    @Column private String telefono;
    @Column private String direccion;
    @Column(nullable = false) private Boolean activo;

    @Column (name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @PrePersist
    protected void onCreate() {
        this.creadoEn = LocalDateTime.now();
    }

    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }

}
