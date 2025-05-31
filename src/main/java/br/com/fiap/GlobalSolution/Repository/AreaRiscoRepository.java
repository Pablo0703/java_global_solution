package br.com.fiap.GlobalSolution.Repository;

import br.com.fiap.GlobalSolution.Entity.AreaRisco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRiscoRepository extends JpaRepository<AreaRisco, Long> {
}

