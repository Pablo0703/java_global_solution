package br.com.fiap.GlobalSolution.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeituraSensorDTO {

    private Long id;

    @NotBlank
    private String idSensor;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    private BigDecimal valor;

    @NotBlank
    @Size(max = 10)
    private String unidade;
}

