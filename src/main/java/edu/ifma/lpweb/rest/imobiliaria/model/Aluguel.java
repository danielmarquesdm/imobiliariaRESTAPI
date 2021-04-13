package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_locacao")
    private Locacao locacao;

    @Column(name = "dt_vencimento")
    private LocalDate dataDeVencimento;
    @Column(name = "valor_pago")
    private BigDecimal valorPago;
    @Column(name = "obs")
    private String observacoes;
    @Column
    private LocalDateTime deletedAt;
}
