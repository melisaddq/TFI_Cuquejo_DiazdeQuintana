package ar.edu.utn.tupad.sigcoin.repositories;

import ar.edu.utn.tupad.sigcoin.domain.entities.CobranzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CobranzaRepository extends JpaRepository<CobranzaEntity, Long> {
}
