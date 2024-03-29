package org.cursojava.springdata;

import org.cursojava.springdata.dao.repository.TelefoneRepository;
import org.cursojava.springdata.dao.repository.UsuarioRepository;
import org.cursojava.springdata.model.Telefone;
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

    @Autowired
    private TelefoneRepository telefoneRepository;


    @Test
    public void testeInsert() {
        Usuario usuario = new Usuario();
        usuario.setEmail("teste6@gmail.com");
        usuario.setIdade(6);
        usuario.setLogin("teste6");
        usuario.setSenha("teste6");
        usuario.setNome("teste6");

        usuarioRepository.save(usuario);

        System.out.println("Usuários cadastrados: " + usuarioRepository.count());
    }

    @Test
    public void testeConsultaPorId() {
        Optional<Usuario> usuario = usuarioRepository.findById(1L);
        System.out.println(usuario.get().getId());
        System.out.println(usuario.get().getEmail());
        System.out.println(usuario.get().getLogin());
        System.out.println(usuario.get().getSenha());
        System.out.println(usuario.get().getNome());
        System.out.println(usuario.get().getIdade());

        for (Telefone telefone : usuario.get().getTelefoneList()) {
            System.out.println(telefone.getNumero());
            System.out.println(telefone.getTipo());
            System.out.println(telefone.getId());
            System.out.println(telefone.getUsuario().getNome());
            System.out.println("--------------------------------");
        }
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
        List<Usuario> usuarioList = usuarioRepository.buscaPorNome("teste");

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
    public void testeConsultaPorNomeParam() {
        Usuario usuario = usuarioRepository.buscarPorNomeParam("teste3");

            System.out.println(usuario.getId());
            System.out.println(usuario.getEmail());
            System.out.println(usuario.getLogin());
            System.out.println(usuario.getSenha());
            System.out.println(usuario.getNome());
            System.out.println(usuario.getIdade());
            System.out.println("-------------------------------");
    }

    @Test
    public void testeDeletePorNome() {
        usuarioRepository.deletePorNome("teste5");
    }

    @Test
    public void testeUpdateEmailPorNome() {
        usuarioRepository.updateEmailPorNome("teste@gmail.com", "teste4");
    }

    @Test
    public void testeConsulta() {
        System.out.println("Spring carregado com sucesso!");
    }

    @Test
    public void testeInsertTelefone() {
        Optional<Usuario> usuario = usuarioRepository.findById(1L);

        Telefone telefone = new Telefone();
        telefone.setTipo("Celular");
        telefone.setNumero("999999999");
        telefone.setUsuario(usuario.get());

        telefoneRepository.save(telefone);
    }
}
