package org.cursojava.conexaojdbc;

import org.cursojava.conexaojdbc.dao.UsuarioDAO;
import org.cursojava.conexaojdbc.model.Usuario;
import org.junit.Test;

public class TesteConexaoBanco {

    @Test
    public void initBanco() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();

        usuario.setId(4L);
        usuario.setNome("Paulo");
        usuario.setEmail("paulo@gmail.com");
        usuarioDAO.salvar(usuario);
    }
}
