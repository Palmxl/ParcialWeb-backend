package parcial.web.martin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.web.martin.entities.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long>{

}
