package ar.edu.utn.tupad.sigcoin.repositories;

import ar.edu.utn.tupad.sigcoin.domain.entities.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprobanteRepository extends JpaRepository<Comprobante,Long> {
}
