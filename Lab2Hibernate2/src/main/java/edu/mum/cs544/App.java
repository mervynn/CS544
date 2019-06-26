package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> query = em.createQuery("from edu.mum.cs544.Students", Students.class);
        List<Students> studentsList = query.getResultList();
        for (Students s : studentsList) System.out.println(s.getName());
        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();
        int geId = (int) (new Date().getTime()/1000);
        System.out.println("Please input student name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        Students newOne = Students.builder()
                .id(geId)
                .email("xxx@xx.com")
                .password("xxxxxx")
                .name(name).build();
        em.persist(newOne);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        query = em.createQuery("from edu.mum.cs544.Students", Students.class);
        studentsList = query.getResultList();
        for (Students s : studentsList) System.out.println(s.getName());
        em.getTransaction().commit();
        em.close();
    }
}
