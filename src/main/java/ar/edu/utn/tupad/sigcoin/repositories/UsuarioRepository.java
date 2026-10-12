package ar.edu.utn.tupad.sigcoin.repositories;

import ar.edu.utn.tupad.sigcoin.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
