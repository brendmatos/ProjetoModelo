
package br.ulbra.model;

import java.util.Date;

public class Cliente {
        private Long id;
    private String nomeCliente;
    private String cpf;
    private Date dataNascimento; 

    public Cliente() {
    }

    public Cliente(Long id, String nomeCliente, String cpf, Date dataNascimento) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}