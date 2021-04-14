package edu.ifma.lpweb.rest.imobiliaria.controller.request;

import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(1)
    @Max(Integer.MAX_VALUE)
    private int dormitorios;
    @Min(1)
    @Max(Integer.MAX_VALUE)
    private int suites;
    @Min(1)
    @Max(Integer.MAX_VALUE)
    private int banheiros;
    @NotNull
    private BigDecimal valorDeAluguelSugerido;
    @NotEmpty
    private String observacoes;

    public Imovel toModel() {
        Imovel imovel = new Imovel();
        return getImovel(imovel);
    }

    private Imovel getImovel(Imovel imovel) {
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

    public Imovel toModel(Long id) {
        Imovel imovel = new Imovel();
        imovel.setId(id);
        return getImovel(imovel);
    }
}
