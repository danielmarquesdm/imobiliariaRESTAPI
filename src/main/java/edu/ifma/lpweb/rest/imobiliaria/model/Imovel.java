package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "tipo_imovel")
    private String tipoImovel;
    @Column
    private String endereco;
    @Column
    private String cep;
    @Column
    private double metragem;
    @Column
    private int dormitorios;
    @Column
    private int banheiros;
    @Column
    private int suites;
    @Column(name = "valor_aluguel_sug")
    private BigDecimal valorDeAluguelSugerido;
    @Column(name = "obs")
    private String observacoes;
    @Column
    private LocalDateTime deletedAt;

}
