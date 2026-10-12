package ar.edu.utn.tupad.sigcoin.infrastructure.services.externos;

import ar.edu.utn.tupad.sigcoin.domain.model.Usuario;
import ar.edu.utn.tupad.sigcoin.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario getUsuarioPorEmail(String email) {
        var entity = usuarioRepository.findByEmail(email);
        return Usuario.fromEntity(
                entity.orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con email: " + email))
        );
    }
}
