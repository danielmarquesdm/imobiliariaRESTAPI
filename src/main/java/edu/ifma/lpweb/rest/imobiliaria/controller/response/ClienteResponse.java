package edu.ifma.lpweb.rest.imobiliaria.controller.response;

import edu.ifma.lpweb.rest.imobiliaria.model.Cliente;
import edu.ifma.lpweb.rest.imobiliaria.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ClienteResponse {
    private Long id;
    private String nome;
    private String cpf;
    private Telefone telefone1;
    private Telefone telefone2;
    private String email;
    private LocalDate dataNascimento;

    public static ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNomeCliente(),
                cliente.getCpf(),
                cliente.getTelefone1(),
                cliente.getTelefone2(),
                cliente.getEmail(),
                cliente.getDataNascimento()
        );
    }
}
