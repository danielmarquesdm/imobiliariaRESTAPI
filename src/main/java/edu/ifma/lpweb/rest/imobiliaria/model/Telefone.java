package edu.ifma.lpweb.rest.imobiliaria.model;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone {
    private String numero;
    private boolean isCelular;

   //CONSTRUTOR


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isCelular() {
        return isCelular;
    }

    public void setIsCelular(boolean celular) {
        isCelular = celular;
    }


}
