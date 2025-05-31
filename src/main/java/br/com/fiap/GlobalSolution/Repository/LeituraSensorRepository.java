package br.com.fiap.GlobalSolution.Repository;

import br.com.fiap.GlobalSolution.Entity.LeituraSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeituraSensorRepository extends JpaRepository<LeituraSensor, Long> {
    List<LeituraSensor> findBySensorId(String sensorId);
}



