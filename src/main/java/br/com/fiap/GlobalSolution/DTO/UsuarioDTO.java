package br.com.fiap.GlobalSolution.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 255, message = "A senha deve ter entre 6 e 255 caracteres")
    private String senha;

    @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres")
    private String telefone;

    @NotBlank(message = "O perfil (tipo de usuário) é obrigatório")
    @Size(max = 15, message = "O perfil deve ter no máximo 15 caracteres")
    private String perfil;

    private LocalDate dataCadastro;
}
