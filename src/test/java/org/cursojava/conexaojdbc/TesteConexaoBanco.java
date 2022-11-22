package org.cursojava.conexaojdbc;

import org.cursojava.conexaojdbc.dao.UsuarioDAO;
import org.cursojava.conexaojdbc.model.Usuario;
import org.junit.Test;

import java.util.List;

public class TesteConexaoBanco {

    @Test
    public void insertBanco() { // Método insert, salvar dados no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();

        usuario.setNome("Paulo");
        usuario.setEmail("paulo@gmail.com");
        usuarioDAO.salvar(usuario);
    }

    @Test
    public void listarBanco() { // Método para listar todos os dados no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            List<Usuario> list = usuarioDAO.listar();
            for (Usuario usuario : list) {
                System.out.println(usuario);
                System.out.println("-------------------------------");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void buscarBanco () { // Método para retornar um usuário no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            Usuario usuario = usuarioDAO.buscar(1L);
            System.out.println(usuario);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void atualizarBanco () { // Método para atualizar o nome do usuário no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            Usuario usuario = usuarioDAO.buscar(1L);
            usuario.setNome("Nome alterado");
            usuarioDAO.atualizarNome(usuario);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deletarBanco () { // Método para deletar um usuário no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            usuarioDAO.deletar(6L);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}