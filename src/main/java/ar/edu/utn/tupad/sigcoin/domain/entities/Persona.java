package ar.edu.utn.tupad.sigcoin.domain.entities;

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
@Table(name= "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "tipo_documento")
    private String tipoDocumento;

    @Column (name = "numero_documento")
    private String numeroDocumento;
    @Column private String cuit;
    @Column private String nombre;
    @Column private String apellido;
    @Column private String email;
    @Column private String telefono;
    @Column private String direccion;
    @Column private Boolean activo;

    @Column (name = "creado_en")
    private LocalDateTime creadoEn;

    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }

}
