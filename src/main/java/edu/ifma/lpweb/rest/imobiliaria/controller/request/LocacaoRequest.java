package edu.ifma.lpweb.rest.imobiliaria.controller.request;

import edu.ifma.lpweb.rest.imobiliaria.model.Cliente;
import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import edu.ifma.lpweb.rest.imobiliaria.model.Locacao;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LocacaoRequest {
    @NotNull
    private Imovel imovel;
    @NotNull
    private Cliente cliente;
    @NotNull
    private BigDecimal valorDoAluguel;
    @NotNull
    private BigDecimal percentualDeMulta;
    @NotNull
    private LocalDate dataDeInicio;
    @NotNull
    private LocalDate dataFinal;
    @NotEmpty
    private String diaDoVencimento;
    @NotNull
    private boolean ativo;
    @NotEmpty
    private String observacoes;

    public Locacao toModel() {
        var locacao = new Locacao();
        return getLocacao(locacao);
    }

    public Locacao toModel(Long id) {
        var locacao = new Locacao();
        locacao.setId(id);
        return getLocacao(locacao);
    }

    private Locacao getLocacao(Locacao locacao) {
        locacao.setImovel(this.getImovel());
        locacao.setCliente(this.getCliente());
        locacao.setValorDoAluguel(this.getValorDoAluguel());
        locacao.setPercentualDeMulta(this.getPercentualDeMulta());
        locacao.setDataDeInicio(this.getDataDeInicio());
        locacao.setDataFinal(this.getDataFinal());
        locacao.setDiaDoVencimento(this.getDiaDoVencimento());
        locacao.setAtivo(this.isAtivo());
        locacao.setObservacoes(this.getObservacoes());
        return locacao;
    }
}
