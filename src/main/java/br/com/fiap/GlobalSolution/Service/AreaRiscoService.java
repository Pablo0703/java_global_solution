package br.com.fiap.GlobalSolution.Service;

import br.com.fiap.GlobalSolution.DTO.AreaRiscoDTO;
import br.com.fiap.GlobalSolution.Entity.AreaRisco;
import br.com.fiap.GlobalSolution.Repository.AreaRiscoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AreaRiscoService {

    private final AreaRiscoRepository repository;

    public List<AreaRiscoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public AreaRiscoDTO buscarPorId(Long id) {
        AreaRisco area = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Área de risco não encontrada"));
        return toDto(area);
    }

    @Transactional
    public AreaRiscoDTO cadastrar(AreaRiscoDTO dto) {
        AreaRisco entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Transactional
    public AreaRiscoDTO atualizar(Long id, AreaRiscoDTO dto) {
        AreaRisco area = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Área de risco não encontrada"));

        // atualizar os campos
        area.setNome(dto.getNome());
        area.setLatitude(dto.getLatitude());
        area.setLongitude(dto.getLongitude());
        area.setNivelSeca(dto.getNivelSeca());
        area.setNivelChuva(dto.getNivelChuva());
        area.setNivelPreventivo(dto.getNivelPreventivo());
        area.setNivelEmergencia(dto.getNivelEmergencia());
        area.setNivelEvacuacao(dto.getNivelEvacuacao());
        area.setAreaAlagadaAlerta(dto.getAreaAlagadaAlerta());
        area.setAreaAlagadaEmergencia(dto.getAreaAlagadaEmergencia());
        area.setMetodoNivel(dto.getMetodoNivel());
        area.setMetodoExtensao(dto.getMetodoExtensao());
        area.setFonte(dto.getFonte());
        area.setUltimaAtualizacao(dto.getUltimaAtualizacao());
        area.setResponsavel(dto.getResponsavel());
        area.setDescricao(dto.getDescricao());

        return toDto(repository.save(area));
    }

    @Transactional
    public void excluir(Long id) {
        AreaRisco area = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Área de risco não encontrada"));
        repository.delete(area);
    }

    private AreaRisco toEntity(AreaRiscoDTO dto) {
        return AreaRisco.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .nivelSeca(dto.getNivelSeca())
                .nivelChuva(dto.getNivelChuva())
                .nivelPreventivo(dto.getNivelPreventivo())
                .nivelEmergencia(dto.getNivelEmergencia())
                .nivelEvacuacao(dto.getNivelEvacuacao())
                .areaAlagadaAlerta(dto.getAreaAlagadaAlerta())
                .areaAlagadaEmergencia(dto.getAreaAlagadaEmergencia())
                .metodoNivel(dto.getMetodoNivel())
                .metodoExtensao(dto.getMetodoExtensao())
                .fonte(dto.getFonte())
                .ultimaAtualizacao(dto.getUltimaAtualizacao())
                .responsavel(dto.getResponsavel())
                .descricao(dto.getDescricao())
                .build();
    }

    private AreaRiscoDTO toDto(AreaRisco entity) {
        return AreaRiscoDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .nivelSeca(entity.getNivelSeca())
                .nivelChuva(entity.getNivelChuva())
                .nivelPreventivo(entity.getNivelPreventivo())
                .nivelEmergencia(entity.getNivelEmergencia())
                .nivelEvacuacao(entity.getNivelEvacuacao())
                .areaAlagadaAlerta(entity.getAreaAlagadaAlerta())
                .areaAlagadaEmergencia(entity.getAreaAlagadaEmergencia())
                .metodoNivel(entity.getMetodoNivel())
                .metodoExtensao(entity.getMetodoExtensao())
                .fonte(entity.getFonte())
                .ultimaAtualizacao(entity.getUltimaAtualizacao())
                .responsavel(entity.getResponsavel())
                .descricao(entity.getDescricao())
                .build();
    }
}
