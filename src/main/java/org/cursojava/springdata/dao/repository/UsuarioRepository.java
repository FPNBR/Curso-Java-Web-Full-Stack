package org.cursojava.springdata.dao.repository;

import org.cursojava.springdata.model.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    @Query(value = "select u from Usuario u where u.nome like %?1%")
    public List<Usuario> buscaPorNome(String nome);

    @Query(value = "select u from Usuario u where u.nome = :paramnome")
    public Usuario buscarPorNomeParam (@Param("paramnome") String nome);

    @Modifying
    @Transactional
    @Query(value = "delete from Usuario u where u.nome = ?1")
    public void deletePorNome(String nome);

    @Modifying
    @Transactional
    @Query(value = "update Usuario u set u.email = ?1 where u.nome = ?2")
    public void updateEmailPorNome(String email, String nome);
}
