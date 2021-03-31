package edu.ifma.lpweb.rest.imobiliaria.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Imovel implements EntidadeBase {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull //valida na camada service
	@Column(nullable = false) //cria coluna not null no banco
	private String tipoImovel;

	@Embedded
	private Endereco endereco;

	private double metragem;

	private int qtdDormitorios;

	private int qtdBanheiros;

	private int qtdSuites;

	private int qtdVagasNaGaragem;

	private BigDecimal valorDeAluguelSugerido;

	private String observacoes;


	//CONSTRUTOR


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public double getMetragem() {
		return metragem;
	}

	public void setMetragem(double metragem) {
		this.metragem = metragem;
	}

	public int getQtdDormitorios() {
		return qtdDormitorios;
	}

	public void setQtdDormitorios(int qtdDormitorios) {
		this.qtdDormitorios = qtdDormitorios;
	}

	public int getQtdBanheiros() {
		return qtdBanheiros;
	}

	public void setQtdBanheiros(int qtdBanheiros) {
		this.qtdBanheiros = qtdBanheiros;
	}

	public int getQtdSuites() {
		return qtdSuites;
	}

	public void setQtdSuites(int qtdSuites) {
		this.qtdSuites = qtdSuites;
	}

	public int getQtdVagasNaGaragem() {
		return qtdVagasNaGaragem;
	}

	public void setQtdVagasNaGaragem(int qtdVagasNaGaragem) {
		this.qtdVagasNaGaragem = qtdVagasNaGaragem;
	}

	public BigDecimal getValorDeAluguelSugerido() {
		return valorDeAluguelSugerido;
	}

	public void setValorDeAluguelSugerido(BigDecimal valorDeAluguelSugerido) {
		this.valorDeAluguelSugerido = valorDeAluguelSugerido;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}
