package parcial.web.martin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import parcial.web.martin.entities.Entidad;

public interface EntidadRepository extends JpaRepository<Entidad, Long> {

}
