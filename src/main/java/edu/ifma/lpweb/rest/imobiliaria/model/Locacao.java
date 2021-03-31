package edu.ifma.lpweb.rest.imobiliaria.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Locacao implements EntidadeBase{

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


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValorDoAluguel() {
		return valorDoAluguel;
	}

	public void setValorDoAluguel(BigDecimal valorDoAluguel) {
		this.valorDoAluguel = valorDoAluguel;
	}

	public BigDecimal getPercentualDeMulta() {
		return percentualDeMulta;
	}

	public void setPercentualDeMulta(BigDecimal percentualDeMulta) {
		this.percentualDeMulta = percentualDeMulta;
	}

	public LocalDate getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(LocalDate dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public LocalDate getDateFinal() {
		return dateFinal;
	}

	public void setDateFinal(LocalDate dateFinal) {
		this.dateFinal = dateFinal;
	}

	public String getDiaDoVencimento() {
		return diaDoVencimento;
	}

	public void setDiaDoVencimento(String diaDoVencimento) {
		this.diaDoVencimento = diaDoVencimento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


}


