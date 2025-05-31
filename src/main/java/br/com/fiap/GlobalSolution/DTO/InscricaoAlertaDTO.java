package br.com.fiap.GlobalSolution.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscricaoAlertaDTO {

    private Long id;

    @NotNull
    private Long idUsuario;

    @NotNull
    private Long idArea;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    private Boolean receberEmail;

    @NotNull
    private Boolean receberSms;

    @NotNull
    private Boolean receberPush;
}

