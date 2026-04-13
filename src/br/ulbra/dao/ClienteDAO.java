package br.ulbra.dao;

import br.ulbra.model.Cliente;
import java.util.List;

public interface ClienteDAO {

    void salvar(Cliente cliente);

    List<Cliente> listar();

    Cliente buscarPorId(Long id);

    void atualizar(Cliente cliente);

    void deletar(Long id);
}
