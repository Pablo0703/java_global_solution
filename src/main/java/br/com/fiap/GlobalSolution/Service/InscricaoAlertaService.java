package br.com.fiap.GlobalSolution.Service;

import br.com.fiap.GlobalSolution.DTO.InscricaoAlertaDTO;
import br.com.fiap.GlobalSolution.Entity.AreaRisco;
import br.com.fiap.GlobalSolution.Entity.InscricaoAlerta;
import br.com.fiap.GlobalSolution.Entity.Usuario;
import br.com.fiap.GlobalSolution.Repository.AreaRiscoRepository;
import br.com.fiap.GlobalSolution.Repository.InscricaoAlertaRepository;
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
public class InscricaoAlertaService {

    private final InscricaoAlertaRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final AreaRiscoRepository areaRiscoRepository;

    public List<InscricaoAlertaDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public InscricaoAlertaDTO buscarPorId(Long id) {
        InscricaoAlerta inscricao = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscrição não encontrada"));
        return toDto(inscricao);
    }

    @Transactional
    public InscricaoAlertaDTO cadastrar(InscricaoAlertaDTO dto) {
        InscricaoAlerta inscricao = toEntity(dto);
        return toDto(repository.save(inscricao));
    }

    @Transactional
    public InscricaoAlertaDTO atualizar(Long id, InscricaoAlertaDTO dto) {
        InscricaoAlerta inscricao = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscrição não encontrada"));

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        AreaRisco area = areaRiscoRepository.findById(dto.getIdArea())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Área de risco não encontrada"));

        inscricao.setUsuario(usuario);
        inscricao.setArea(area);
        inscricao.setTimestamp(dto.getTimestamp());
        inscricao.setReceberEmail(dto.getReceberEmail());
        inscricao.setReceberSms(dto.getReceberSms());
        inscricao.setReceberPush(dto.getReceberPush());

        return toDto(repository.save(inscricao));
    }

    @Transactional
    public void excluir(Long id) {
        InscricaoAlerta inscricao = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscrição não encontrada"));
        repository.delete(inscricao);
    }

    private InscricaoAlerta toEntity(InscricaoAlertaDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        AreaRisco area = areaRiscoRepository.findById(dto.getIdArea())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Área de risco não encontrada"));

        return InscricaoAlerta.builder()
                .id(dto.getId())
                .usuario(usuario)
                .area(area)
                .timestamp(dto.getTimestamp())
                .receberEmail(dto.getReceberEmail())
                .receberSms(dto.getReceberSms())
                .receberPush(dto.getReceberPush())
                .build();
    }

    private InscricaoAlertaDTO toDto(InscricaoAlerta entity) {
        return InscricaoAlertaDTO.builder()
                .id(entity.getId())
                .idUsuario(entity.getUsuario().getId())
                .idArea(entity.getArea().getId())
                .timestamp(entity.getTimestamp())
                .receberEmail(entity.getReceberEmail())
                .receberSms(entity.getReceberSms())
                .receberPush(entity.getReceberPush())
                .build();
    }
}