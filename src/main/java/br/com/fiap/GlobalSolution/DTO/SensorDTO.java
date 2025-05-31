package br.com.fiap.GlobalSolution.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorDTO {
    @NotBlank
    @Size(max = 50)
    private String id;

    @NotNull
    private Long idArea;

    @NotBlank
    @Size(max = 20)
    private String tipo;

    @Size(max = 60)
    private String modelo;

    @NotNull
    private LocalDate dataInstalacao;

    private LocalDate ultimaManutencao;

    @NotBlank
    @Size(max = 15)
    private String status;
}