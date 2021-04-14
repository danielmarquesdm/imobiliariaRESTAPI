package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Endereco {
    private String cep;
    private String bairro;
}
