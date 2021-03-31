package edu.ifma.lpweb.rest.imobiliaria.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Cliente implements EntidadeBase {

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



   //CONSTRUTOR


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Telefone getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(Telefone telefone1) {
        this.telefone1 = telefone1;
    }

    public Telefone getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(Telefone telefone2) {
        this.telefone2 = telefone2;
    }
}
