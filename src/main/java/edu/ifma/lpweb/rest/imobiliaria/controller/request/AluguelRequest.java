package edu.ifma.lpweb.rest.imobiliaria.controller.request;

import edu.ifma.lpweb.rest.imobiliaria.model.Aluguel;
import edu.ifma.lpweb.rest.imobiliaria.model.Locacao;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AluguelRequest {
    @NotNull
    private Locacao locacao;
    @NotNull
    private LocalDate dataDeVencimento;
    @NotNull
    private BigDecimal valorPago;
    @NotEmpty
    private String observacoes;

    public Aluguel toModel() {
        var aluguel = new Aluguel();
        aluguel.setLocacao(this.getLocacao());
        aluguel.setDataDeVencimento(this.getDataDeVencimento());
        aluguel.setValorPago(this.getValorPago());
        aluguel.setObservacoes(this.getObservacoes());
        return aluguel;
    }

    public Aluguel toModel(Long id) {
        var aluguel = new Aluguel();
        aluguel.setId(this.locacao.getId());
        aluguel.setLocacao(this.getLocacao());
        aluguel.setDataDeVencimento(this.getDataDeVencimento());
        aluguel.setValorPago(this.getValorPago());
        aluguel.setObservacoes(this.getObservacoes());
        return aluguel;
    }
}
