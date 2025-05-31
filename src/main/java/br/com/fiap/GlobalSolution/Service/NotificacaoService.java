package br.com.fiap.GlobalSolution.Service;

import br.com.fiap.GlobalSolution.DTO.NotificacaoDTO;
import br.com.fiap.GlobalSolution.Entity.Alerta;
import br.com.fiap.GlobalSolution.Entity.Notificacao;
import br.com.fiap.GlobalSolution.Entity.Usuario;
import br.com.fiap.GlobalSolution.Repository.AlertaRepository;
import br.com.fiap.GlobalSolution.Repository.NotificacaoRepository;
import br.com.fiap.GlobalSolution.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final AlertaRepository alertaRepository;

    public List<NotificacaoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public NotificacaoDTO buscarPorId(Long id) {
        Notificacao notificacao = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Notificação não encontrada"));
        return toDto(notificacao);
    }

    @Transactional
    public NotificacaoDTO cadastrar(NotificacaoDTO dto) {
        Notificacao notificacao = toEntity(dto);
        return toDto(repository.save(notificacao));
    }

    @Transactional
    public NotificacaoDTO atualizar(Long id, NotificacaoDTO dto) {
        Notificacao notificacao = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Notificação não encontrada"));

        Alerta alerta = alertaRepository.findById(dto.getIdAlerta())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        notificacao.setAlerta(alerta);
        notificacao.setUsuario(usuario);
        notificacao.setTimestampEnvio(dto.getTimestampEnvio());
        notificacao.setCanalEnvio(dto.getCanalEnvio());
        notificacao.setStatusEnvio(dto.getStatusEnvio());

        return toDto(repository.save(notificacao));
    }

    @Transactional
    public void excluir(Long id) {
        Notificacao notificacao = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Notificação não encontrada"));
        repository.delete(notificacao);
    }

    private Notificacao toEntity(NotificacaoDTO dto) {
        Alerta alerta = alertaRepository.findById(dto.getIdAlerta())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        return Notificacao.builder()
                .id(dto.getId())
                .alerta(alerta)
                .usuario(usuario)
                .timestampEnvio(dto.getTimestampEnvio())
                .canalEnvio(dto.getCanalEnvio())
                .statusEnvio(dto.getStatusEnvio())
                .build();
    }

    private NotificacaoDTO toDto(Notificacao entity) {
        return NotificacaoDTO.builder()
                .id(entity.getId())
                .idAlerta(entity.getAlerta().getId())
                .idUsuario(entity.getUsuario().getId())
                .timestampEnvio(entity.getTimestampEnvio())
                .canalEnvio(entity.getCanalEnvio())
                .statusEnvio(entity.getStatusEnvio())
                .build();
    }
}
