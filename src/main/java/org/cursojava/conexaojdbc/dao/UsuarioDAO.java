package org.cursojava.conexaojdbc.dao;

import org.cursojava.conexaojdbc.SingleConnection;
import org.cursojava.conexaojdbc.model.Telefone;
import org.cursojava.conexaojdbc.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        connection = SingleConnection.getConnection();
    }

    public void criarUsuario(Usuario usuario) {
        try {
            String sql = "insert into usuarios (nome, email) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.execute();
            connection.commit(); // Salva no banco
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public List<Usuario> listarUsuario() throws SQLException {
        List<Usuario> list = new ArrayList<>();

        String sql = "select * from usuarios";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ResultSet resultado = prepareStatement.executeQuery();

        while (resultado.next()) { // Retorna todos os usuários do banco de dados
            Usuario usuario = new Usuario();
            usuario.setId(resultado.getLong("id"));
            usuario.setNome(resultado.getString("nome"));
            usuario.setEmail(resultado.getString("email"));
            list.add(usuario);
        }
        return list;
    }

    public Usuario buscarUsuario(Long id) throws Exception {
        Usuario usuario = new Usuario();

        String sql = "select * from usuarios where id = " + id;

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ResultSet resultado = prepareStatement.executeQuery();

        while (resultado.next()) { // Retorna apenas um ou nenhum usuário do banco de dados
            usuario.setId(resultado.getLong("id"));
            usuario.setNome(resultado.getString("nome"));
            usuario.setEmail(resultado.getString("email"));
        }
        if (usuario.getId() == null) {
            throw new Exception("Usuário não encontrado");
        }
        return usuario;
    }

    public void atualizarNomeUsuario(Usuario usuario) {
        try {
            String sql = "update usuarios set nome = ? where id = " + usuario.getId();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, usuario.getNome());
            prepareStatement.execute();
            connection.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void deletarUsuario(Long id) throws Exception {
        try {
            String sql = "delete from usuarios where id = " + id;
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
            connection.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void salvarTelefone(Telefone telefone) {
        try {
            String sql = "insert into telefones (numero, tipo, usuario) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, telefone.getNumero());
            preparedStatement.setString(2, telefone.getTipo());
            preparedStatement.setLong(3, telefone.getUsuario());
            preparedStatement.execute();
            connection.commit(); // Salva no banco
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}