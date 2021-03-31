package edu.ifma.lpweb.rest.imobiliaria.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
public class Cliente  {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeCliente;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "numero", column = @Column(name = "telefone1")),
            @AttributeOverride(name = "isCelular", column = @Column(name = "iscelular1"))
    })
    @NotNull
    @Column(nullable = false)
    private Telefone telefone1;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "numero", column = @Column(name = "telefone2")),
            @AttributeOverride(name = "isCelular", column = @Column(name = "iscelular2"))
    })
    private Telefone telefone2;
}
