package org.cursojava.jpahibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    public static EntityManagerFactory entityManagerFactory = null;

    static {
        init();
    }

    private static void init() {
        try {
            if (entityManagerFactory == null) {
                entityManagerFactory = Persistence.createEntityManagerFactory("jpa"); // Pega as configurações da persistence.xml
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager(); // Fornece a parte de persistência
    }
}
