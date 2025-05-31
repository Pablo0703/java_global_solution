package br.com.fiap.GlobalSolution.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SMAE_NOTIFICACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NOTIFICACAO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_ALERTA", nullable = false)
    private Alerta alerta;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @Column(name = "TIMESTAMP_ENVIO")
    private LocalDateTime timestampEnvio;

    @Column(name = "CANAL_ENVIO", length = 10)
    private String canalEnvio;

    @Column(name = "STATUS_ENVIO", length = 10)
    private String statusEnvio;
}


