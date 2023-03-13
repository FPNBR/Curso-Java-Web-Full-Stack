package org.cursojava.springdata.dao.repository;

import org.cursojava.springdata.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    @Query(value = "select u from Usuario u where u.nome like %?1%")
    public List<Usuario> buscaPorNome(String nome);
}
