package br.com.fiap.GlobalSolution.Repository;

import br.com.fiap.GlobalSolution.Entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String> {
    List<Sensor> findByAreaId(Long areaId);
}

