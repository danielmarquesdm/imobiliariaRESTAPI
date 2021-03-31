package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Locacao {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_imovel", insertable = true, updatable = true)
	private Imovel imovel;


	@ManyToOne
	@JoinColumn(name = "id_inquilino", insertable = true, updatable = true)
	private Cliente cliente;

	private BigDecimal valorDoAluguel;

	private BigDecimal percentualDeMulta;

	private LocalDate dataDeInicio;

	private LocalDate dateFinal;

	private String diaDoVencimento;

	private boolean ativo;

	private String observacoes;

}


