package edu.ifma.lpweb.rest.imobiliaria.controller.response;

import edu.ifma.lpweb.rest.imobiliaria.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ClienteResponse {
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;

    public static ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNomeCliente(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getDataNascimento()
        );
    }
}
