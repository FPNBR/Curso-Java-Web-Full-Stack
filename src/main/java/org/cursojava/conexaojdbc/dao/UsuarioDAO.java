package org.cursojava.conexaojdbc.dao;

import org.cursojava.conexaojdbc.SingleConnection;
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

    public void salvar(Usuario usuario) {
        try {
            String sql = "insert into usuarios (id, nome, email) values (?,?,?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setLong(1, usuario.getId());
            insert.setString(2, usuario.getNome());
            insert.setString(3, usuario.getEmail());
            insert.execute();
            connection.commit(); // Salva no banco
        }
        catch (Exception e) {
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public List<Usuario> listar() throws Exception {
        List<Usuario> list = new ArrayList<>();

        String sql = "select * from usuarios";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();

        while (resultado.next()) { // Retorna todos os usuários do banco de dados
            Usuario usuario = new Usuario();
            usuario.setId(resultado.getLong("id"));
            usuario.setNome(resultado.getString("nome"));
            usuario.setEmail(resultado.getString("email"));
            list.add(usuario);
        }
        return list;
    }

    public Usuario buscar(Long id) throws Exception {
        Usuario usuarioRetorno = new Usuario();

        String sql = "select * from usuarios where id = " + id;

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();

        while (resultado.next()) { // Retorna apenas um ou nenhum usuário do banco de dados
            usuarioRetorno.setId(resultado.getLong("id"));
            usuarioRetorno.setNome(resultado.getString("nome"));
            usuarioRetorno.setEmail(resultado.getString("email"));
        }
        return usuarioRetorno;
    }

    public void atualizarNome(Usuario usuario) {
        try {
            String sql = "update usuarios set nome = ? where id = " + usuario.getId();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.execute();
            connection.commit();
        }
        catch (Exception e) {
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}