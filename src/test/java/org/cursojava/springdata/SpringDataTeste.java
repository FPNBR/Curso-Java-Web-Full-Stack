package org.cursojava.springdata;

import org.cursojava.springdata.dao.repository.UsuarioRepository;
import org.cursojava.springdata.model.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

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
    public void testeConsultaPorId() {
        Optional<Usuario> usuario = usuarioRepository.findById(2L);
        System.out.println(usuario.get().getId());
        System.out.println(usuario.get().getEmail());
        System.out.println(usuario.get().getLogin());
        System.out.println(usuario.get().getSenha());
        System.out.println(usuario.get().getNome());
        System.out.println(usuario.get().getIdade());
    }

    @Test
    public void testeConsultaTodos() {
        Iterable<Usuario> usuarioIterable = usuarioRepository.findAll();

        for (Usuario usuario : usuarioIterable) {
            System.out.println(usuario.getId());
            System.out.println(usuario.getEmail());
            System.out.println(usuario.getLogin());
            System.out.println(usuario.getSenha());
            System.out.println(usuario.getNome());
            System.out.println(usuario.getIdade());
            System.out.println("-------------------------------");
        }
    }

    @Test
    public void testeUpdate() {
        Optional<Usuario> usuario = usuarioRepository.findById(3L);
        Usuario data = usuario.get();
        data.setNome("Testando Update");
        data.setIdade(99);
        usuarioRepository.save(data);
    }

    @Test
    public void testeDelete() {
        //Optional<Usuario> usuario = usuarioRepository.findById(3L);
        //usuarioRepository.delete(usuario.get());

        usuarioRepository.deleteById(5L);
    }

    @Test
    public void testeConsultaPorNome() {
        List<Usuario> usuarioList = usuarioRepository.buscaPorNome("teste1");

        for (Usuario usuario : usuarioList) {
            System.out.println(usuario.getId());
            System.out.println(usuario.getEmail());
            System.out.println(usuario.getLogin());
            System.out.println(usuario.getSenha());
            System.out.println(usuario.getNome());
            System.out.println(usuario.getIdade());
            System.out.println("-------------------------------");
        }
    }

    @Test
    public void testeConsulta() {
        System.out.println("Spring carregado com sucesso!");
    }
}
