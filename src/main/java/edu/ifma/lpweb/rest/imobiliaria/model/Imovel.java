package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Imovel {
    @Id
    private Long id;
    private String tipoimovel;
    private String endereco;
    private String cep;
    private int dormitorios;
    private int banheiros;
    private int suites;
    private int metragem;
    private BigDecimal valorAluguelSugerido;
    private String observacao;
}
