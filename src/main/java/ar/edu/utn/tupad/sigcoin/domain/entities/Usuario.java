package ar.edu.utn.tupad.sigcoin.domain.entities;


import ar.edu.utn.tupad.sigcoin.domain.enums.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column
    private Rol rol;

    @Column private Boolean activo;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn;

    // Métodos de dominio
    public void iniciarSesion() {
        // Lógica de dominio para inicio de sesión
    }

    public void cerrarSesion() {
        // Lógica de dominio para cierre de sesión
    }
}
