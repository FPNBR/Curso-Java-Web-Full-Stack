package org.cursojava.jpahibernate;

import org.cursojava.jpahibernate.models.DAO.DaoGenerico;
import org.cursojava.jpahibernate.models.Usuario;
import org.junit.Test;

public class TesteHibernateUtil {
    @Test
    public void testeHibernateUtil() {
        DaoGenerico<Usuario> daoGenerico = new DaoGenerico<>();

        Usuario usuario = new Usuario();
        usuario.setIdade(18);
        usuario.setNome("Teste 2");
        usuario.setSobrenome("Testando");
        usuario.setLogin("teste");
        usuario.setSenha("teste");
        usuario.setEmail("usuario@gmail.com");

        daoGenerico.salvarUsuario(usuario);

    }
}
