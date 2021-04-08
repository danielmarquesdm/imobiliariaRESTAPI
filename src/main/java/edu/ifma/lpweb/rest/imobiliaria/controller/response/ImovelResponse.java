package edu.ifma.lpweb.rest.imobiliaria.controller.response;

import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ImovelResponse {
    private Long id;
    private String tipoImovel;
    private String endereco;
    private String cep;
    private double metragem;
    private int dormitorios;
    private int suites;
    private int banheiros;
    private BigDecimal valorDeAluguelSugerido;
    private String observacoes;

    public static ImovelResponse toResponse(Imovel imovel) {
        return new ImovelResponse(
                imovel.getId(),
                imovel.getTipoImovel(),
                imovel.getEndereco(),
                imovel.getCep(),
                imovel.getMetragem(),
                imovel.getDormitorios(),
                imovel.getSuites(),
                imovel.getBanheiros(),
                imovel.getValorDeAluguelSugerido(),
                imovel.getObservacoes()
        );
    }
}
