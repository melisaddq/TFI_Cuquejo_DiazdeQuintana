package ar.edu.utn.tupad.sigcoin.repositories;

import ar.edu.utn.tupad.sigcoin.domain.entities.InmueblePropietarioEntity;
import ar.edu.utn.tupad.sigcoin.domain.entities.InmueblePropietarioEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmueblePropietarioRepository extends JpaRepository<InmueblePropietarioEntity, InmueblePropietarioEntityId> {
}
