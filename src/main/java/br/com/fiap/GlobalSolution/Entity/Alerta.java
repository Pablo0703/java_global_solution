package br.com.fiap.GlobalSolution.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SMAE_ALERTA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALERTA")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_AREA")
    private AreaRisco area;

    @ManyToOne
    @JoinColumn(name = "ID_LEITURA_GATILHO")
    private LeituraSensor leituraGatilho;

    @Column(name = "TIMESTAMP_ALERTA")
    private LocalDateTime timestamp;

    @Column(name = "TIPO_ALERTA")
    private String tipo;

    @Column(name = "MENSAGEM_ALERTA")
    private String mensagem;

    @Column(name = "STATUS_ALERTA")
    private String status;
}