package edu.mum.framework.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
    private static final ThreadLocal<EntityManager> emh;
    private static final EntityManagerFactory emf;
    static {
        emf  = Persistence.createEntityManagerFactory("cs544");
        emh  = new ThreadLocal<>();
    }
    public static EntityManager getEntityManager() {
        EntityManager em = emh.get();
        if (em == null || !em.isOpen()) emh.set(emf.createEntityManager());
        return emh.get();
    }

    public static void closeEntityManagerFactory(){
        emf.close();
    }
}
