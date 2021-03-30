package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Locacao {
    @Id
    private Long id;
    private boolean ativo;
    private LocalDate dataFim;
    private LocalDate dataInicio;
    private int diaVencimento;
    private BigDecimal percentualMulta;
    private BigDecimal valorAluguel;
    private String observacao;

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Imovel imovel;
}
