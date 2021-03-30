package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Aluguel {
    @Id
    private Long id;
    private LocalDate dataVencimento;
    private BigDecimal valorPago;
    private String observacao;

    @ManyToOne
    private Locacao locacao;
}
