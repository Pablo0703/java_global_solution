package br.com.fiap.GlobalSolution.Service;

import br.com.fiap.GlobalSolution.DTO.SensorDTO;
import br.com.fiap.GlobalSolution.Entity.AreaRisco;
import br.com.fiap.GlobalSolution.Entity.Sensor;
import br.com.fiap.GlobalSolution.Repository.AreaRiscoRepository;
import br.com.fiap.GlobalSolution.Repository.SensorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository repository;
    private final AreaRiscoRepository areaRiscoRepository;

    public List<SensorDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public SensorDTO buscarPorId(String id) {
        Sensor sensor = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sensor não encontrado"));
        return toDto(sensor);
    }

    @Transactional
    public SensorDTO cadastrar(SensorDTO dto) {
        Sensor sensor = toEntity(dto);
        return toDto(repository.save(sensor));
    }

    @Transactional
    public SensorDTO atualizar(String id, SensorDTO dto) {
        Sensor sensor = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sensor não encontrado"));

        AreaRisco area = areaRiscoRepository.findById(dto.getIdArea())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Área de risco não encontrada"));

        sensor.setArea(area);
        sensor.setTipo(dto.getTipo());
        sensor.setModelo(dto.getModelo());
        sensor.setDataInstalacao(dto.getDataInstalacao());
        sensor.setUltimaManutencao(dto.getUltimaManutencao());
        sensor.setStatus(dto.getStatus());

        return toDto(repository.save(sensor));
    }

    @Transactional
    public void excluir(String id) {
        Sensor sensor = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sensor não encontrado"));
        repository.delete(sensor);
    }

    private Sensor toEntity(SensorDTO dto) {
        AreaRisco area = areaRiscoRepository.findById(dto.getIdArea())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Área de risco não encontrada"));

        return Sensor.builder()
                .id(dto.getId())
                .area(area)
                .tipo(dto.getTipo())
                .modelo(dto.getModelo())
                .dataInstalacao(dto.getDataInstalacao())
                .ultimaManutencao(dto.getUltimaManutencao())
                .status(dto.getStatus())
                .build();
    }

    private SensorDTO toDto(Sensor entity) {
        return SensorDTO.builder()
                .id(entity.getId())
                .idArea(entity.getArea().getId())
                .tipo(entity.getTipo())
                .modelo(entity.getModelo())
                .dataInstalacao(entity.getDataInstalacao())
                .ultimaManutencao(entity.getUltimaManutencao())
                .status(entity.getStatus())
                .build();
    }
}
