package edu.mum.cs544;

import edu.mum.cs544.domain.Abc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        Abc abc = new Abc(null, "name1");
        em.getTransaction().begin();
        em.persist(abc);
        abc.setName("name2");
        abc.setName("name3");
        em.persist(abc);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        Abc abcQueried = em.find(Abc.class, 1l);
        System.out.println(abcQueried);
        abcQueried.setName("name4");
        em.persist(abcQueried);
        em.getTransaction().commit();
        em.close();

    }
}
