package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Telefone {
    private String numero;
    private boolean isCelular;
}
