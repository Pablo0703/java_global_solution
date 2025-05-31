package br.com.fiap.GlobalSolution.Service;

import br.com.fiap.GlobalSolution.DTO.AlertaDTO;
import br.com.fiap.GlobalSolution.Entity.Alerta;
import br.com.fiap.GlobalSolution.Entity.AreaRisco;
import br.com.fiap.GlobalSolution.Entity.LeituraSensor;
import br.com.fiap.GlobalSolution.Repository.AlertaRepository;
import br.com.fiap.GlobalSolution.Repository.AreaRiscoRepository;
import br.com.fiap.GlobalSolution.Repository.LeituraSensorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlertaService {

    private final AlertaRepository repository;
    private final AreaRiscoRepository areaRepository;
    private final LeituraSensorRepository leituraRepository;

    public List<AlertaDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public AlertaDTO buscarPorId(Long id) {
        Alerta alerta = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado"));
        return toDto(alerta);
    }

    @Transactional
    public AlertaDTO cadastrar(AlertaDTO dto) {
        Alerta alerta = toEntity(dto);
        return toDto(repository.save(alerta));
    }

    @Transactional
    public AlertaDTO atualizar(Long id, AlertaDTO dto) {
        Alerta alerta = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado"));

        AreaRisco area = areaRepository.findById(dto.getIdArea())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Área de risco não encontrada"));

        LeituraSensor leitura = leituraRepository.findById(dto.getIdLeituraGatilho())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Leitura não encontrada"));

        alerta.setArea(area);
        alerta.setLeituraGatilho(leitura);
        alerta.setTimestamp(dto.getTimestamp());
        alerta.setTipo(dto.getTipo());
        alerta.setMensagem(dto.getMensagem());
        alerta.setStatus(dto.getStatus());

        return toDto(repository.save(alerta));
    }

    @Transactional
    public void excluir(Long id) {
        Alerta alerta = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado"));
        repository.delete(alerta);
    }

    private Alerta toEntity(AlertaDTO dto) {
        AreaRisco area = areaRepository.findById(dto.getIdArea())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Área de risco não encontrada"));

        LeituraSensor leitura = leituraRepository.findById(dto.getIdLeituraGatilho())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Leitura não encontrada"));

        return Alerta.builder()
                .area(area)
                .leituraGatilho(leitura)
                .timestamp(dto.getTimestamp())
                .tipo(dto.getTipo())
                .mensagem(dto.getMensagem())
                .status(dto.getStatus())
                .build();
    }

    private AlertaDTO toDto(Alerta entity) {
        return AlertaDTO.builder()
                .id(entity.getId())
                .idArea(entity.getArea().getId())
                .idLeituraGatilho(entity.getLeituraGatilho().getId())
                .timestamp(entity.getTimestamp())
                .tipo(entity.getTipo())
                .mensagem(entity.getMensagem())
                .status(entity.getStatus())
                .build();
    }
}

