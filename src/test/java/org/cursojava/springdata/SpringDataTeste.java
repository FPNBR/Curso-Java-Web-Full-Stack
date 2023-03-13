package org.cursojava.springdata;

import org.cursojava.springdata.dao.repository.UsuarioRepository;
import org.cursojava.springdata.model.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class SpringDataTeste {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void testeInsert() {
        Usuario usuario = new Usuario();
        usuario.setEmail("teste5@gmail.com");
        usuario.setIdade(5);
        usuario.setLogin("teste5");
        usuario.setSenha("teste5");
        usuario.setNome("teste5");

        usuarioRepository.save(usuario);

        System.out.println("Usuários cadastrados: " + usuarioRepository.count());
    }

    @Test
    public void testeConsulta() {
        System.out.println("Spring carregado com sucesso!");
    }
}
