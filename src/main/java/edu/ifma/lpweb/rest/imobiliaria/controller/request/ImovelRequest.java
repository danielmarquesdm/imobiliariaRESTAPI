package edu.ifma.lpweb.rest.imobiliaria.controller.request;

import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ImovelRequest {
    @NotEmpty
    private String tipoImovel;
    @NotEmpty
    private String endereco;
    @NotEmpty
    private String cep;
    @NotNull
    private double metragem;
    @NotNull
    private int dormitorios;
    @NotNull
    private int suites;
    @NotNull
    private int banheiros;
    @NotNull
    private BigDecimal valorDeAluguelSugerido;
    @NotEmpty
    private String observacoes;

    public Imovel toModel() {
        Imovel imovel = new Imovel();
        imovel.setTipoImovel(this.getTipoImovel());
        imovel.setEndereco(this.getEndereco());
        imovel.setCep(this.getCep());
        imovel.setMetragem(this.getMetragem());
        imovel.setDormitorios(this.getDormitorios());
        imovel.setSuites(this.getSuites());
        imovel.setBanheiros(this.getBanheiros());
        imovel.setValorDeAluguelSugerido(this.getValorDeAluguelSugerido());
        imovel.setObservacoes(this.getObservacoes());
        return imovel;
    }
}
