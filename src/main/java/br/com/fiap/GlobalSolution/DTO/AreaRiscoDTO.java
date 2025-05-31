package br.com.fiap.GlobalSolution.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaRiscoDTO {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotNull
    private BigDecimal latitude;

    @NotNull
    private BigDecimal longitude;

    @NotNull
    private BigDecimal nivelSeca;

    @NotNull
    private BigDecimal nivelChuva;

    @NotNull
    private BigDecimal nivelPreventivo;

    @NotNull
    private BigDecimal nivelEmergencia;

    @NotNull
    private BigDecimal nivelEvacuacao;

    @NotNull
    private BigDecimal areaAlagadaAlerta;

    @NotNull
    private BigDecimal areaAlagadaEmergencia;

    @Size(max = 100)
    private String metodoNivel;

    @Size(max = 100)
    private String metodoExtensao;

    @Size(max = 100)
    private String fonte;

    private LocalDateTime ultimaAtualizacao;

    @Size(max = 100)
    private String responsavel;

    private String descricao;
}

