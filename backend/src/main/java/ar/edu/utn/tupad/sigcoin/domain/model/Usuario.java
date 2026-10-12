package ar.edu.utn.tupad.sigcoin.domain.model;

import ar.edu.utn.tupad.sigcoin.domain.entities.UsuarioEntity;
import ar.edu.utn.tupad.sigcoin.domain.enums.Rol;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {

    private String email;
    private String nombre;
    private Long id;
    private Rol rol;

    public static Usuario fromEntity(UsuarioEntity entity) {
        Usuario usuario = new Usuario();
        usuario.setId(entity.getId());
        usuario.setNombre(entity.getNombreUsuario());
        usuario.setEmail(entity.getEmail());
        usuario.setRol(entity.getRol());
        return usuario;
    }
}
