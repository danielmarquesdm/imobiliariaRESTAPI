package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_imovel")
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(name = "id_inquilino")
    private Cliente cliente;

    @Column(name = "valor_aluguel")
    private BigDecimal valorDoAluguel;
    @Column(name = "perc_multa")
    private BigDecimal percentualDeMulta;
    @Column(name = "data_inicio")
    private LocalDate dataDeInicio;
    @Column(name = "data_fim")
    private LocalDate dataFinal;
    @Column(name = "dia_vencimento")
    private String diaDoVencimento;
    @Column
    private boolean ativo;
    @Column(name = "obs")
    private String observacoes;

}


