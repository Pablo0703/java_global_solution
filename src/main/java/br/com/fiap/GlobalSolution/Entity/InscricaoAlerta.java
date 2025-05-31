package br.com.fiap.GlobalSolution.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SMAE_INSCRICAO_ALERTA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscricaoAlerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INSCRICAO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_AREA")
    private AreaRisco area;

    @Column(name = "TIMESTAMP_INSCRICAO")
    private LocalDateTime timestamp;

    @Column(name = "RECEBER_EMAIL")
    private Boolean receberEmail;

    @Column(name = "RECEBER_SMS")
    private Boolean receberSms;

    @Column(name = "RECEBER_PUSH")
    private Boolean receberPush;
}

