package br.ulbra.dao;

import br.ulbra.model.Usuario;
import java.util.List;

public interface UsuarioDAO {

    void salvar(Usuario usuario);

    List<Usuario> listar();

    Usuario buscarPorId(Long id);

    void atualizar(Usuario usuario);

    void deletar(Long id);
}