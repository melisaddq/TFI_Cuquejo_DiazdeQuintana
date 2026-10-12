package ar.edu.utn.tupad.sigcoin.repositories;

import ar.edu.utn.tupad.sigcoin.domain.entities.InmueblePropietario;
import ar.edu.utn.tupad.sigcoin.domain.entities.InmueblePropietarioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmueblePropietarioRepository extends JpaRepository<InmueblePropietario,InmueblePropietarioId> {
}
