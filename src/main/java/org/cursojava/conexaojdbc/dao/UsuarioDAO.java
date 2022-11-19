package org.cursojava.conexaojdbc.dao;

import org.cursojava.conexaojdbc.SingleConnection;

import java.sql.Connection;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        connection = SingleConnection.getConnection();
    }
}
