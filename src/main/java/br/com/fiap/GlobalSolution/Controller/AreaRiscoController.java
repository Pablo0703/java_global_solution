package br.com.fiap.GlobalSolution.Controller;

import br.com.fiap.GlobalSolution.DTO.AreaRiscoDTO;
import br.com.fiap.GlobalSolution.Service.AreaRiscoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
@RequiredArgsConstructor
public class AreaRiscoController {

    private final AreaRiscoService service;

    @GetMapping
    public List<AreaRiscoDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaRiscoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AreaRiscoDTO> cadastrar(@RequestBody @Valid AreaRiscoDTO dto) {
        AreaRiscoDTO criado = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaRiscoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AreaRiscoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

