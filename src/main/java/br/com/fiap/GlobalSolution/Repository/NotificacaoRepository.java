package br.com.fiap.GlobalSolution.Repository;

import br.com.fiap.GlobalSolution.Entity.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    List<Notificacao> findByUsuarioId(Long usuarioId);
}

