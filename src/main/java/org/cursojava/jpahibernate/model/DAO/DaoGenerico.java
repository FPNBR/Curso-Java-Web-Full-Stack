package org.cursojava.jpahibernate.model.DAO;

import org.cursojava.jpahibernate.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DaoGenerico<E> {
    private EntityManager entityManager = HibernateUtil.getEntityManager();

    public void salvarUsuario(E entidade) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(entidade);
        entityTransaction.commit();
    }

    public E salvarAtualizarUsuario(E entidade) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        E entidadeSalva = entityManager.merge(entidade);
        entityTransaction.commit();

        return entidadeSalva;
    }

    public E pesquisarUsuario(E entidade) {
        Object id = HibernateUtil.getPrimaryKey(entidade);
        E e = (E) entityManager.find(entidade.getClass(), id);
        return e;
    }

    public E pesquisarUsuario(Long id, Class<E> entidade) {
        E e = (E) entityManager.find(entidade, id);
        return e;
    }

    public void deletarUsuarioPorId(E entidade) {
        Object id = HibernateUtil.getPrimaryKey(entidade);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id =" + id).executeUpdate();
        entityTransaction.commit();
    }
}
