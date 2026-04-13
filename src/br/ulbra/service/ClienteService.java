package br.ulbra.service;

import br.ulbra.dao.ClienteDAO;
import br.ulbra.dao.ClienteDAOImpl;
import br.ulbra.model.Cliente;
import java.util.List;

public class ClienteService {

    private ClienteDAO dao;

    public ClienteService(ClienteDAO dao) {
        this.dao = dao;
    }

    public ClienteService(ClienteDAOImpl clienteDAOImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cadastrar(Cliente cliente) {

        if (cliente.getNomeCliente() == null || cliente.getNomeCliente().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }

        if (cliente.getCpf() == null || !cliente.getCpf().matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido (deve conter 11 números)");
        }

        if (cliente.getDataNascimento() == null) {
            throw new IllegalArgumentException("Data de nascimento obrigatória");
        }

        dao.salvar(cliente);
    }

    public List<Cliente> listar() {
        return dao.listar();
    }

    public void atualizar(Cliente cliente) {

        if (cliente.getId() == null) {
            throw new IllegalArgumentException("ID obrigatório para atualização");
        }

        cadastrar(cliente); 
        dao.atualizar(cliente);
    }

    public void deletar(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }

        dao.deletar(id);
    }

    public Cliente buscar(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }

        return dao.buscarPorId(id);
    }
}
