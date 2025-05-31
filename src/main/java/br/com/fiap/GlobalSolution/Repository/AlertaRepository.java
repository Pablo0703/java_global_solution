package br.com.fiap.GlobalSolution.Repository;


import br.com.fiap.GlobalSolution.Entity.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    List<Alerta> findByAreaId(Long areaId);
    List<Alerta> findByStatus(String status);
}

