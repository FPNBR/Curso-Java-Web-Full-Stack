/*
package org.cursojava.jpahibernate;

import org.cursojava.jpahibernate.model.DAO.DaoGenerico;
import org.cursojava.jpahibernate.model.TelefoneUsuarioHibernate;
import org.cursojava.jpahibernate.model.UsuarioHibernate;
import org.junit.Test;

import java.util.List;

public class TesteHibernate {
    @Test
    public void testeHibernateUtil() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();

        UsuarioHibernate usuarioHibernate = new UsuarioHibernate();
        usuarioHibernate.setIdade(1);
        usuarioHibernate.setNome("Teste 1");
        usuarioHibernate.setSobrenome("Testando");
        usuarioHibernate.setLogin("teste1");
        usuarioHibernate.setSenha("teste1");
        usuarioHibernate.setEmail("teste1@gmail.com");

        daoGenerico.salvarUsuario(usuarioHibernate);
    }

    @Test
    public void testeBuscarUsuario() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();
        UsuarioHibernate usuarioHibernate = new UsuarioHibernate();
        usuarioHibernate.setId(1L);

        usuarioHibernate = daoGenerico.pesquisarUsuario(usuarioHibernate);
        System.out.println(usuarioHibernate);
    }

    @Test
    public void testeBuscarUsuario2() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();

        UsuarioHibernate usuarioHibernate = daoGenerico.pesquisarUsuario(1L, UsuarioHibernate.class);
        System.out.println(usuarioHibernate);
    }

    @Test
    public void testeAtualizarUsuario() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();

        UsuarioHibernate usuarioHibernate = daoGenerico.pesquisarUsuario(1L, UsuarioHibernate.class);
        usuarioHibernate.setIdade(99);
        usuarioHibernate.setNome("Nome atualizado");

        usuarioHibernate = daoGenerico.salvarAtualizarUsuario(usuarioHibernate);
        System.out.println(usuarioHibernate);
    }

    @Test
    public void testeDeletarUsuario() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();
        UsuarioHibernate usuarioHibernate = daoGenerico.pesquisarUsuario(1L, UsuarioHibernate.class);

        daoGenerico.deletarUsuarioPorId(usuarioHibernate);
    }

    @Test
    public void testeListarUsuario() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();

        List<UsuarioHibernate> usuarioHibernateList = daoGenerico.listarUsuarios(UsuarioHibernate.class);
        for (UsuarioHibernate usuarioHibernate : usuarioHibernateList) {
            System.out.println(usuarioHibernate);
            System.out.println("----------------------------------------------");
        }
    }

    @Test
    public void testeQueryList() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();
        List<UsuarioHibernate> usuarioHibernateList = daoGenerico.getEntityManager().createQuery(" from UsuarioHibernate where nome = 'Teste 1'").getResultList();

        for (UsuarioHibernate usuarioHibernate : usuarioHibernateList) {
            System.out.println(usuarioHibernate);
        }
    }

    @Test
    public void testeQueryListMaxResult() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();
        List<UsuarioHibernate> usuarioHibernateList = daoGenerico.getEntityManager().createQuery(" from UsuarioHibernate order by id")
                .setMaxResults(2)
                .getResultList();

        for (UsuarioHibernate usuarioHibernate : usuarioHibernateList) {
            System.out.println(usuarioHibernate);
        }
    }

    @Test
    public void testeQueryListParameter() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();

        List<UsuarioHibernate> usuarioHibernateList = daoGenerico.getEntityManager().createQuery(" from UsuarioHibernate where nome = :nome or sobrenome = :sobrenome")
                .setParameter("nome", "Teste 1")
                .setParameter("sobrenome", "Testando 1")
                .getResultList();

        for (UsuarioHibernate usuarioHibernate : usuarioHibernateList) {
            System.out.println(usuarioHibernate);
        }
    }

    @Test
    public void testeQuerySomaIdade() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();

        Long somaIdade = (Long) daoGenerico.getEntityManager().createQuery("select  sum(u.idade) from UsuarioHibernate u ").getSingleResult();

        System.out.println("A soma de todas as idades é -> " + somaIdade);
    }

    @Test
    public void testeNamedQuery1() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();

        List<UsuarioHibernate> usuarioHibernateList = daoGenerico.getEntityManager().createNamedQuery("Usuario.buscarTodos").getResultList();

        for (UsuarioHibernate usuarioHibernate : usuarioHibernateList) {
            System.out.println(usuarioHibernate);
        }
    }

    @Test
    public void testeNamedQuery2() {
        DaoGenerico<UsuarioHibernate> daoGenerico = new DaoGenerico<>();

        List<UsuarioHibernate> usuarioHibernateList = daoGenerico.getEntityManager().createNamedQuery("Usuario.buscarPorNome")
                .setParameter("nome", "Teste 1")
                .getResultList();

        for (UsuarioHibernate usuarioHibernate : usuarioHibernateList) {
            System.out.println(usuarioHibernate);
        }
    }

    @Test
    public void testeSalvarTelefone() {
        DaoGenerico daoGenerico = new DaoGenerico<>();
        UsuarioHibernate usuarioHibernate = (UsuarioHibernate) daoGenerico.pesquisarUsuario(2L, UsuarioHibernate.class);

        TelefoneUsuarioHibernate telefoneUsuarioHibernate = new TelefoneUsuarioHibernate();
        telefoneUsuarioHibernate.setTipo("Casa");
        telefoneUsuarioHibernate.setNumero("999999998");
        telefoneUsuarioHibernate.setUsuario(usuarioHibernate);

        daoGenerico.salvarUsuario(telefoneUsuarioHibernate);
    }

    @Test
    public void testeConsultarTelefones() {
        DaoGenerico daoGenerico = new DaoGenerico<>();
        UsuarioHibernate usuarioHibernate = (UsuarioHibernate) daoGenerico.pesquisarUsuario(2L, UsuarioHibernate.class);

        for (TelefoneUsuarioHibernate telefoneUsuarioHibernate : usuarioHibernate.getTelefoneUsuarioHibernateList()) {
            System.out.println(telefoneUsuarioHibernate.getNumero());
            System.out.println(telefoneUsuarioHibernate.getTipo());
            System.out.println(telefoneUsuarioHibernate.getUsuario().getNome());
            System.out.println("---------------------------------------");
        }
    }
}
*/