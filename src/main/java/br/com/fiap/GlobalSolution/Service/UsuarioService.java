package br.com.fiap.GlobalSolution.Service;

import br.com.fiap.GlobalSolution.DTO.UsuarioDTO;
import br.com.fiap.GlobalSolution.Entity.Usuario;
import br.com.fiap.GlobalSolution.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public List<UsuarioDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        return toDto(usuario);
    }

    @Transactional
    public UsuarioDTO cadastrar(UsuarioDTO dto) {
        Usuario usuario = toEntity(dto);
        usuario.setDataCadastro(LocalDate.now());
        return toDto(repository.save(usuario));
    }

    @Transactional
    public UsuarioDTO atualizar(Long id, UsuarioDTO dto) {
        Usuario existente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setTelefone(dto.getTelefone());
        existente.setTipoUsuario(dto.getPerfil());
        existente.setSenhaHash(dto.getSenha());

        return toDto(repository.save(existente));
    }

    @Transactional
    public void excluir(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        repository.delete(usuario);
    }

    private Usuario toEntity(UsuarioDTO dto) {
        return Usuario.builder()
                //.id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .tipoUsuario(dto.getPerfil())
                .senhaHash(dto.getSenha())
                .build();
    }

    private UsuarioDTO toDto(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .telefone(usuario.getTelefone())
                .perfil(usuario.getTipoUsuario())
                .senha(usuario.getSenhaHash())
                .dataCadastro(usuario.getDataCadastro())
                .build();
    }
}