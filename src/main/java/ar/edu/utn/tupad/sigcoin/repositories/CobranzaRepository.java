package ar.edu.utn.tupad.sigcoin.repositories;

import ar.edu.utn.tupad.sigcoin.domain.entities.Cobranza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CobranzaRepository extends JpaRepository<Cobranza, Long> {
}
