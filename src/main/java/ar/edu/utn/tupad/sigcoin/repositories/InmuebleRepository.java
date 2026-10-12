package ar.edu.utn.tupad.sigcoin.repositories;

import ar.edu.utn.tupad.sigcoin.domain.entities.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble,Long> {
}
