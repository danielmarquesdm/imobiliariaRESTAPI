package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Cliente  {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_cliente")
    private String nomeCliente;
    @Column
    private String cpf;
    @Column
    private String email;
    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;
    @Column(nullable = false)
    private String telefone;
}
