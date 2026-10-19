package br.ifgoiano.cpr.contareceber;

import br.ifgoiano.cpr.pessoa.Pessoa;
import br.ifgoiano.cpr.planoconta.PlanoConta;
import br.ifgoiano.cpr.shared.enums.SituacaoConta;
import br.ifgoiano.cpr.shared.enums.TipoTitulo;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class ContaReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String numeroTitulo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "plano_conta_id", nullable = false)
    private PlanoConta planoConta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoTitulo tipoTitulo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private SituacaoConta situacao = SituacaoConta.ABERTA;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate emissao;

    @Column(nullable = false)
    private LocalDate vencimento;

    @Column(precision = 14, scale = 2)
    private BigDecimal desconto = BigDecimal.ZERO;

    private LocalDate validadeDesc;

    @Column(precision = 14, scale = 2)
    private BigDecimal acrescimo = BigDecimal.ZERO;

    private LocalDate dataRecebimento;

    @Column(precision = 14, scale = 2)
    private BigDecimal valorRecebido;

    @Column(length = 255)
    private String observacao;
}