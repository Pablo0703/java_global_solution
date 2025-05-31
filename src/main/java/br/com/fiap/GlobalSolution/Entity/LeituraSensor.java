package br.com.fiap.GlobalSolution.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SMAE_LEITURA_SENSOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeituraSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LEITURA")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_SENSOR")
    private Sensor sensor;

    @Column(name = "TIMESTAMP_LEITURA")
    private LocalDateTime timestamp;

    @Column(name = "VALOR_LEITURA")
    private BigDecimal valor;

    @Column(name = "UNIDADE_MEDIDA")
    private String unidade;
}