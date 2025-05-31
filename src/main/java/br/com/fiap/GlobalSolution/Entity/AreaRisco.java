package br.com.fiap.GlobalSolution.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SMAE_AREA_RISCO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaRisco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AREA")
    private Long id;

    @Column(name = "NOME_AREA")
    private String nome;

    @Column(name = "LATITUDE")
    private BigDecimal latitude;

    @Column(name = "LONGITUDE")
    private BigDecimal longitude;

    @Column(name = "NIVEL_NORMAL_ESTACAO_SECA")
    private BigDecimal nivelSeca;

    @Column(name = "NIVEL_NORMAL_ESTACAO_CHUVA")
    private BigDecimal nivelChuva;

    @Column(name = "NIVEL_ALERTA_PREVENTIVO")
    private BigDecimal nivelPreventivo;

    @Column(name = "NIVEL_ALERTA_EMERGENCIA")
    private BigDecimal nivelEmergencia;

    @Column(name = "NIVEL_EVACUACAO")
    private BigDecimal nivelEvacuacao;

    @Column(name = "AREA_ALAGADA_ALERTA")
    private BigDecimal areaAlagadaAlerta;

    @Column(name = "AREA_ALAGADA_EMERGENCIA")
    private BigDecimal areaAlagadaEmergencia;

    @Column(name = "METODO_MEDICAO_NIVEL")
    private String metodoNivel;

    @Column(name = "METODO_MEDICAO_EXTENSAO")
    private String metodoExtensao;

    @Column(name = "FONTE_DADOS")
    private String fonte;

    @Column(name = "ULTIMA_ATUALIZACAO")
    private LocalDateTime ultimaAtualizacao;

    @Column(name = "RESPONSAVEL_ATUALIZACAO")
    private String responsavel;

    @Column(name = "DESCRICAO")
    private String descricao;
}