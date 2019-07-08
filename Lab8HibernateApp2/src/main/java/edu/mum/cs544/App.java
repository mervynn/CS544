package edu.mum.cs544;

import javax.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Student s1 = new Student();
        Student s2 = new Student();
        System.out.println(s1.getStudentid());
        System.out.println(s2.getStudentid());
        em.persist(s1);
        em.persist(s2);
        em.clear();
        System.out.println(s1.getStudentid());
        System.out.println(s2.getStudentid());
        em.getTransaction().commit();
        em.close();

        em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        System.out.println(em.createQuery("from Student ").getResultList());
        em.getTransaction().commit();
        em.close();

        Long a = 1L;
    }
}
