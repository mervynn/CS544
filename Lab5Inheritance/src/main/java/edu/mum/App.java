package edu.mum;

import edu.mum.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Date;

public class App {

    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer customer = new Customer();
        customer.setFirstname("Sky");
        customer.setLastname("Li");
        em.persist(customer);
        Book p1 = new Book("book-name", "book-description", "book-title");
        CD p2 = new CD("cd-name", "cd-description", "cd-genre");
        DVD p3 = new DVD("dvd-name", "dvd-description", "dvd-artist");
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        OrderLine ol = new OrderLine(null, 2, p1);
        OrderLine ol1 = new OrderLine(null, 3, p2);
        Order order = new Order(null, new Date(), null, Arrays.asList(ol, ol1));
        em.persist(order);
        customer.addOrder(order);
        em.persist(customer);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em.createQuery("from Customer").getResultList());
        em.getTransaction().commit();
        em.close();
    }
}
