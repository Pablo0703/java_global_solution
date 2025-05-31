package br.com.fiap.GlobalSolution.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaDTO {

    private Long id;

    @NotNull
    private Long idArea;

    @NotNull
    private Long idLeituraGatilho;

    @NotNull
    private LocalDateTime timestamp;

    @NotBlank
    @Size(max = 20)
    private String tipo;

    @NotBlank
    @Size(max = 500)
    private String mensagem;

    @NotBlank
    @Size(max = 10)
    private String status;
}




