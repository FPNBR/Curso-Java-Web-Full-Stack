package org.cursojava.jpahibernate.models.DAO;

import org.cursojava.jpahibernate.HibernateUtil;

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
}
