package ar.edu.utn.tupad.sigcoin.repositories;

import ar.edu.utn.tupad.sigcoin.domain.entities.CajaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CajaRepository extends JpaRepository<CajaEntity,Long> {
}
