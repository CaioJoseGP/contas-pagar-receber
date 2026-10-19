package br.ifgoiano.cpr.pessoa;

import br.ifgoiano.cpr.shared.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Data
@Entity
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private TipoPessoa tipo;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 18)
    private String documento;

    @Column(length = 15)
    private String inscricaoEstadual;

    @Column(length = 120)
    private String endereco;

    @Column(length = 50)
    private String cidade;

    @Column(length = 2)
    private String uf;

    @Column(length = 9)
    private String cep;

    @Column(length = 20)
    private String telefone;

    @Column(length = 80)
    private String email;

    @Column(length = 50)
    private String contato;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime criadoEm;
}