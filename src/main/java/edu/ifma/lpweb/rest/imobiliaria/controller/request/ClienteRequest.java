package edu.ifma.lpweb.rest.imobiliaria.controller.request;

import edu.ifma.lpweb.rest.imobiliaria.model.Cliente;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ClienteRequest {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String cpf;
    @NotEmpty
    private String telefone;
    @NotEmpty
    private String email;
    @NotNull
    private LocalDate dataNascimento;

    public Cliente toModel() {
        Cliente cliente = new Cliente();
        cliente.setNomeCliente(this.getNome());
        cliente.setCpf(this.getCpf());
        cliente.setTelefone(this.getTelefone());
        cliente.setEmail(this.getEmail());
        cliente.setDataNascimento(this.getDataNascimento());
        return cliente;
    }

    public Cliente toModel(Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNomeCliente(this.getNome());
        cliente.setCpf(this.getCpf());
        cliente.setTelefone(this.getTelefone());
        cliente.setEmail(this.getEmail());
        cliente.setDataNascimento(this.getDataNascimento());
        return cliente;
    }
}
