package edu.ifma.lpweb.rest.imobiliaria.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String cep;
    private String bairro;

    //CONSTRUTOR


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
