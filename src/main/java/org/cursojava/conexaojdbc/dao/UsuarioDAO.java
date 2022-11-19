package org.cursojava.conexaojdbc.dao;

import org.cursojava.conexaojdbc.SingleConnection;
import org.cursojava.conexaojdbc.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
