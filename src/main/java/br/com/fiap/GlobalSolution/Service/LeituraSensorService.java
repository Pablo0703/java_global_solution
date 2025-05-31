package br.com.fiap.GlobalSolution.Service;

import br.com.fiap.GlobalSolution.DTO.LeituraSensorDTO;
import br.com.fiap.GlobalSolution.Entity.LeituraSensor;
import br.com.fiap.GlobalSolution.Entity.Sensor;
import br.com.fiap.GlobalSolution.Repository.LeituraSensorRepository;
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
public class LeituraSensorService {

    private final LeituraSensorRepository repository;
    private final SensorRepository sensorRepository;

    public List<LeituraSensorDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public LeituraSensorDTO buscarPorId(Long id) {
        LeituraSensor leitura = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Leitura não encontrada"));
        return toDto(leitura);
    }

    @Transactional
    public LeituraSensorDTO cadastrar(LeituraSensorDTO dto) {
        LeituraSensor leitura = toEntity(dto);
        return toDto(repository.save(leitura));
    }

    @Transactional
    public LeituraSensorDTO atualizar(Long id, LeituraSensorDTO dto) {
        LeituraSensor leitura = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Leitura não encontrada"));

        Sensor sensor = sensorRepository.findById(dto.getIdSensor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sensor não encontrado"));

        leitura.setSensor(sensor);
        leitura.setTimestamp(dto.getTimestamp());
        leitura.setValor(dto.getValor());
        leitura.setUnidade(dto.getUnidade());

        return toDto(repository.save(leitura));
    }

    @Transactional
    public void excluir(Long id) {
        LeituraSensor leitura = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Leitura não encontrada"));
        repository.delete(leitura);
    }

    private LeituraSensor toEntity(LeituraSensorDTO dto) {
        Sensor sensor = sensorRepository.findById(dto.getIdSensor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sensor não encontrado"));

        return LeituraSensor.builder()
                .id(dto.getId())
                .sensor(sensor)
                .timestamp(dto.getTimestamp())
                .valor(dto.getValor())
                .unidade(dto.getUnidade())
                .build();
    }

    private LeituraSensorDTO toDto(LeituraSensor entity) {
        return LeituraSensorDTO.builder()
                .id(entity.getId())
                .idSensor(entity.getSensor().getId())
                .timestamp(entity.getTimestamp())
                .valor(entity.getValor())
                .unidade(entity.getUnidade())
                .build();
    }
}

