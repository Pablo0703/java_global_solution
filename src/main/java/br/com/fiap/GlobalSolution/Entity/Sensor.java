package br.com.fiap.GlobalSolution.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "SMAE_SENSOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sensor {
    @Id
    @Column(name = "ID_SENSOR")
    private String id;

    @ManyToOne
    @JoinColumn(name = "ID_AREA")
    private AreaRisco area;

    @Column(name = "TIPO_SENSOR")
    private String tipo;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "DATA_INSTALACAO")
    private LocalDate dataInstalacao;

    @Column(name = "ULTIMA_MANUTENCAO")
    private LocalDate ultimaManutencao;

    @Column(name = "STATUS_SENSOR")
    private String status;
}