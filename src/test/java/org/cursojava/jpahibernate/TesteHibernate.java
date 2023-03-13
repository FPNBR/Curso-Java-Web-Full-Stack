package org.cursojava.jpahibernate;

import org.cursojava.arquivos.Pessoa;
import org.cursojava.jpahibernate.model.DAO.DaoGenerico;
import org.cursojava.jpahibernate.model.Usuario;
import org.junit.Test;

import java.util.List;

public class TesteHibernate {
    @Test
    public void testeHibernateUtil() {
        DaoGenerico<Usuario> daoGenerico = new DaoGenerico<>();

        Usuario usuario = new Usuario();
        usuario.setIdade(1);
        usuario.setNome("Teste 1");
        usuario.setSobrenome("Testando");
        usuario.setLogin("teste1");
        usuario.setSenha("teste1");
        usuario.setEmail("teste1@gmail.com");

        daoGenerico.salvarUsuario(usuario);
    }

    @Test
    public void testeBuscarUsuario() {
        DaoGenerico<Usuario> daoGenerico = new DaoGenerico<>();
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        usuario = daoGenerico.pesquisarUsuario(usuario);
        System.out.println(usuario);
    }

    @Test
    public void testeBuscarUsuario2() {
        DaoGenerico<Usuario> daoGenerico = new DaoGenerico<>();

        Usuario usuario = daoGenerico.pesquisarUsuario(1L, Usuario.class);
        System.out.println(usuario);
    }

    @Test
    public void testeAtualizarUsuario() {
        DaoGenerico<Usuario> daoGenerico = new DaoGenerico<>();

        Usuario usuario = daoGenerico.pesquisarUsuario(1L, Usuario.class);
        usuario.setIdade(99);
        usuario.setNome("Nome atualizado");

        usuario = daoGenerico.salvarAtualizarUsuario(usuario);
        System.out.println(usuario);
    }

    @Test
    public void testeDeletarUsuario() {
        DaoGenerico<Usuario> daoGenerico = new DaoGenerico<>();
        Usuario usuario = daoGenerico.pesquisarUsuario(1L, Usuario.class);

        daoGenerico.deletarUsuarioPorId(usuario);
    }

    @Test
    public void testeListarUsuario() {
        DaoGenerico<Usuario> daoGenerico = new DaoGenerico<>();

        List<Usuario> usuarioList = daoGenerico.listarUsuarios(Usuario.class);
        for (Usuario usuario : usuarioList) {
            System.out.println(usuario);
            System.out.println("----------------------------------------------");
        }
    }

    @Test
    public void testeQueryList() {
        DaoGenerico<Usuario> daoGenerico = new DaoGenerico<>();
        List<Usuario> usuarioList = daoGenerico.getEntityManager().createQuery(" from Usuario where nome = 'Teste 1'").getResultList();

        for (Usuario usuario : usuarioList) {
            System.out.println(usuario);
        }
    }

    @Test
    public void testeQueryListMaxResult() {
        DaoGenerico<Usuario> daoGenerico = new DaoGenerico<>();
        List<Usuario> usuarioList = daoGenerico.getEntityManager().createQuery(" from Usuario order by id").setMaxResults(2).getResultList();

        for (Usuario usuario : usuarioList) {
            System.out.println(usuario);
        }
    }
}
