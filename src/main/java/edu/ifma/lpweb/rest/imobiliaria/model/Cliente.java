package edu.ifma.lpweb.rest.imobiliaria.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cliente")
    private String nomeCliente;
    @Column
    private String cpf;
    @Column
    private String email;
    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "numero", column = @Column(name = "telefone1")),
            @AttributeOverride(name = "isCelular", column = @Column(name = "is_celular_1"))
    })
    @NotNull
    @Column(nullable = false)
    private Telefone telefone1;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "numero", column = @Column(name = "telefone2")),
            @AttributeOverride(name = "isCelular", column = @Column(name = "is_celular_2"))
    })
    private Telefone telefone2;

    @Column
    private LocalDateTime deletedAt;

}
