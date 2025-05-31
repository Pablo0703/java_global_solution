package br.com.fiap.GlobalSolution.Repository;

import br.com.fiap.GlobalSolution.Entity.InscricaoAlerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscricaoAlertaRepository extends JpaRepository<InscricaoAlerta, Long> {
    List<InscricaoAlerta> findByUsuarioId(Long usuarioId);
    List<InscricaoAlerta> findByAreaId(Long areaId);
}

