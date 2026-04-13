 
package br.ulbra.dao;

import br.ulbra.model.Cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl {

   
    public List<Cliente> listar() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getLong("id"),
                        rs.getString("nomeCliente"),
                        rs.getString("cpf"),
                        rs.getDate("dataNascimento")
                );
                lista.add(c);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    
    public Cliente buscarPorId(Long id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cliente(
                        rs.getLong("id"),
                        rs.getString("nomeCliente"),
                        rs.getString("cpf"),
                        rs.getDate("dataNascimento")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

   
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome_cliente = ?, cpf = ?, data_nascimento = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getCpf());
            stmt.setDate(3, new Date(cliente.getDataNascimento().getTime()));
            stmt.setLong(4, cliente.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    public void deletar(Long id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    public void cadastrar(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome_cliente, cpf, data_nascimento) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getCpf());
            stmt.setDate(3, new Date(cliente.getDataNascimento().getTime()));

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}