package ar.edu.utn.tupad.sigcoin.repositories;

import ar.edu.utn.tupad.sigcoin.domain.entities.SolicitudPagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudPagoRepository extends JpaRepository<SolicitudPagoEntity,Long> {
}
