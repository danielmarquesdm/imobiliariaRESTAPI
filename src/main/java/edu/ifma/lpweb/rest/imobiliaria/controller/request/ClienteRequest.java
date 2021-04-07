package edu.ifma.lpweb.rest.imobiliaria.controller.request;

import edu.ifma.lpweb.rest.imobiliaria.model.Cliente;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteRequest {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;

    public Cliente toModel() {
        return new Cliente(
                this.getNome(),
                this.getCpf(),
                this.getTelefone(),
                this.getEmail(),
                this.getDataNascimento()
        );
    }
}
