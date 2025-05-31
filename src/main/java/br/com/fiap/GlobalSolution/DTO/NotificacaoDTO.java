package br.com.fiap.GlobalSolution.DTO;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificacaoDTO {

    private Long id;

    @NotNull
    private Long idAlerta;

    @NotNull
    private Long idUsuario;

    @NotNull
    private LocalDateTime timestampEnvio;

    @NotBlank
    @Size(max = 10)
    private String canalEnvio;

    @NotBlank
    @Size(max = 10)
    private String statusEnvio;
}

