package br.com.fiap.GlobalSolution.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "SMAE_USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;


    @Column(name = "NOME_USUARIO", nullable = false, length = 100)
    private String nome;

    @Column(name = "EMAIL", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "SENHA_HASH", nullable = false, length = 255)
    private String senhaHash;

    @Column(name = "TELEFONE", length = 20)
    private String telefone;

    @Column(name = "TIPO_USUARIO", length = 15)
    private String tipoUsuario;

    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;
}
