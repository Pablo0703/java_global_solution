package br.com.fiap.GlobalSolution.Controller;

import br.com.fiap.GlobalSolution.DTO.LeituraSensorDTO;
import br.com.fiap.GlobalSolution.Service.LeituraSensorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leituras")
@RequiredArgsConstructor
public class LeituraSensorController {

    private final LeituraSensorService service;

    @GetMapping
    public List<LeituraSensorDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeituraSensorDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<LeituraSensorDTO> cadastrar(@RequestBody @Valid LeituraSensorDTO dto) {
        LeituraSensorDTO criado = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeituraSensorDTO> atualizar(@PathVariable Long id, @RequestBody @Valid LeituraSensorDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}