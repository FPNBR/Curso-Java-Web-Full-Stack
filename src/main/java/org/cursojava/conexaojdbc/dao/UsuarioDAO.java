package org.cursojava.conexaojdbc.dao;

import org.cursojava.conexaojdbc.SingleConnection;
import org.cursojava.conexaojdbc.model.InnerJoinUsuarioFone;
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

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultado = preparedStatement.executeQuery();

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

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultado = preparedStatement.executeQuery();

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
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.execute();
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
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
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

    public List<InnerJoinUsuarioFone> buscarUsuarioFone(Long id) throws Exception {
        List<InnerJoinUsuarioFone> list = new ArrayList<>();

        String sql = " select nome, email, numero from telefones as fone ";
        sql += " inner join usuarios as userp ";
        sql += " on fone.usuario = userp.id ";
        sql += " where userp.id = " + id;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) { // Retorna apenas um ou nenhum usuário e seus telefones do banco de dados
            InnerJoinUsuarioFone innerJoinUsuarioFone = new InnerJoinUsuarioFone();
            innerJoinUsuarioFone.setNome(resultado.getString("nome"));
            innerJoinUsuarioFone.setEmail(resultado.getString("email"));
            innerJoinUsuarioFone.setNumero(resultado.getString("numero"));
            list.add(innerJoinUsuarioFone);
        }
        if (list.isEmpty()) {
            throw new Exception("Usuário não encontrado");
        }
        return list;
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

    public void deletarUsuarioFone(Long id) throws Exception {
        try {
            String sqlFone = "delete from telefones where usuario = " + id;
            String sqlUsuario = "delete from usuarios where id = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sqlFone);
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement = connection.prepareStatement(sqlUsuario);
            preparedStatement.executeUpdate();
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
}