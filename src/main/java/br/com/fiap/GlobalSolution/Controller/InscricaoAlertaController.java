package br.com.fiap.GlobalSolution.Controller;

import br.com.fiap.GlobalSolution.DTO.InscricaoAlertaDTO;
import br.com.fiap.GlobalSolution.Service.InscricaoAlertaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inscricoes")
@RequiredArgsConstructor
public class InscricaoAlertaController {

    private final InscricaoAlertaService service;

    @GetMapping
    public List<InscricaoAlertaDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscricaoAlertaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<InscricaoAlertaDTO> cadastrar(@RequestBody @Valid InscricaoAlertaDTO dto) {
        InscricaoAlertaDTO criado = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscricaoAlertaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid InscricaoAlertaDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
