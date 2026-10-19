package br.ifgoiano.cpr.planoconta;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PlanoConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 18)
    private String codigo;

    @Column(nullable = false, length = 60)
    private String descricao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "superior_id")
    private PlanoConta superior;

    @Column(nullable = false)
    private Boolean consolidada = false;
}