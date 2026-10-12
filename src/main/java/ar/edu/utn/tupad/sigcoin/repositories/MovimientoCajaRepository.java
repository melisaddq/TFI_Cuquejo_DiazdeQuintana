package ar.edu.utn.tupad.sigcoin.repositories;

import ar.edu.utn.tupad.sigcoin.domain.entities.MovimientoCaja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoCajaRepository  extends JpaRepository<MovimientoCaja,Long> {
}
