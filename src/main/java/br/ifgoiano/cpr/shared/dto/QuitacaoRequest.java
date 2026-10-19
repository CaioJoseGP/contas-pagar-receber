package br.ifgoiano.cpr.shared.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class QuitacaoRequest {
    private LocalDate data;
    private BigDecimal desconto;
    private BigDecimal acrescimo;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }
}