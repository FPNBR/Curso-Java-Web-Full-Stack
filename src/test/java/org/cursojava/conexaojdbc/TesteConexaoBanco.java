package org.cursojava.conexaojdbc;

import org.cursojava.conexaojdbc.dao.UsuarioDAO;
import org.cursojava.conexaojdbc.model.InnerJoinUsuarioFone;
import org.cursojava.conexaojdbc.model.Telefone;
import org.cursojava.conexaojdbc.model.Usuario;
import org.junit.Test;

import java.util.List;

public class TesteConexaoBanco {

    @Test
    public void insertUsuario() { // Método insert, salvar usuário no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setEmail("joao@gmail.com");
        usuarioDAO.criarUsuario(usuario);
    }

    @Test
    public void listarUsuario() { // Método para listar todos os usuários no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            List<Usuario> list = usuarioDAO.listarUsuario();
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
    public void buscarUsuario() { // Método para retornar um usuário selecionado no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            Usuario usuario = usuarioDAO.buscarUsuario(5L);
            System.out.println(usuario);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void atualizarUsuario () { // Método para atualizar o nome do usuário no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            Usuario usuario = usuarioDAO.buscarUsuario(7L);
            usuario.setNome("Nome alterado");
            usuarioDAO.atualizarNomeUsuario(usuario);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deletarUsuario () { // Método para deletar um usuário no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            usuarioDAO.deletarUsuario(6L);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTelefone() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Telefone telefone = new Telefone();
        telefone.setNumero("(83) 9 5555-5555");
        telefone.setTipo("Celular");
        telefone.setUsuario(15L);
        usuarioDAO.salvarTelefone(telefone);
    }

    @Test
    public void listarUsuarioFone() { // Método que usa Inner Join do SQL para combinar a tabela de usuários e seus telefones em uma só
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            List<InnerJoinUsuarioFone> list = usuarioDAO.listarUsuarioFone(7L);
            for (InnerJoinUsuarioFone innerJoinUsuarioFone : list) {
                System.out.println(innerJoinUsuarioFone);
                System.out.println("-------------------------------");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}