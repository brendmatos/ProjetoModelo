package br.ulbra.controller;

import br.ulbra.model.Cliente;
import br.ulbra.service.ClienteService;

import java.util.Date;
import java.util.List;

public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

   
    public void cadastrar(String nomeCliente, String cpf, Date dataNascimento) {
        Cliente cliente = new Cliente();
        cliente.setNomeCliente(nomeCliente);
        cliente.setCpf(cpf);
        cliente.setDataNascimento(dataNascimento);

        service.cadastrar(cliente);
    }

   
    public List<Cliente> listar() {
        return service.listar();
    }

   
    public void atualizar(Long id, String nomeCliente, String cpf, Date dataNascimento) {
        Cliente cliente = new Cliente(id, nomeCliente, cpf, dataNascimento);
        service.atualizar(cliente);
    }

    
    public void deletar(Long id) {
        service.deletar(id);
    }
}