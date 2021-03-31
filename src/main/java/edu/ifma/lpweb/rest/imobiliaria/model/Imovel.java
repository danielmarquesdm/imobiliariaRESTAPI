package edu.ifma.lpweb.rest.imobiliaria.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@Entity
public class Imovel  {

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

}
