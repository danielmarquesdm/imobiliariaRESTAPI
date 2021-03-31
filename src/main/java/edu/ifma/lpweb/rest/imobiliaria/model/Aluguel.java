package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Aluguel {

    @Id
    private LocalDate dataDeVencimento;

    @ManyToOne
    private Locacao locacao;

    private BigDecimal valorPago;
    private LocalDate dataDoPagamento;
    private String observacoes;

}
