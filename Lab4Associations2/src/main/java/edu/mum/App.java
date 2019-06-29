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

        // TEST a)
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Department dep = new Department();
        dep.setName("dep1");
        Employee employee = new Employee();
        employee.setName("July :-");
        dep.addEmployee(employee);
        em.persist(employee);
        em.persist(dep);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em.createQuery("from Department", Department.class).getResultList());
        em.getTransaction().commit();
        em.close();

        // TEST b)
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Publisher p = new Publisher(null, "CNN");
        Book b1 = new Book(null, "A001", "book1", p);
        Book b2 = new Book(null, "A002", "book2", p);
        Book b3 = new Book(null, "A003", "book3", null);
        em.persist(p);
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em.createQuery("from Book", Book.class).getResultList());
        em.getTransaction().commit();
        em.close();

        // TEST c)
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Student s1 = new Student(10,"student1");
        Student s2 = new Student(20, "student2");
        Course c1 = new Course("CS582");
        Course c2 = new Course("CS544");
        s1.addCourse(c1);
        s1.addCourse(c2);
        s2.addCourse(c2);
        em.persist(s1);
        em.persist(s2);
        em.persist(c1);
        em.persist(c2);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em.createQuery("from Student", Student.class).getResultList());
        em.getTransaction().commit();
        em.close();

        // TEST d)
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Reservation r1 = new Reservation(1l, "5 mins delay", new Date(), b1);
        Reservation r2 = new Reservation(2l, "5 mins in advance", new Date(), b3);
        Customer customer = new Customer(null, "Xing", Arrays.asList(r1,r2));
        em.merge(customer);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em.createQuery("from Customer", Customer.class).getResultList());
        em.getTransaction().commit();
        em.close();

        // TEST e)
        em = emf.createEntityManager();
        em.getTransaction().begin();
        b1.setName("Test_e_reservation");
        em.merge(r1);
        em.merge(r2);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em.createQuery("from Reservation", Reservation.class).getResultList());
        em.getTransaction().commit();
        em.close();

        // TEST f)
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Office office = new Office();
        office.setLocation("250 2nd St.");
        office.addEmployee(employee);
        em.persist(office);
        em.merge(employee);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em.createQuery("from Office", Office.class).getResultList());
        em.getTransaction().commit();
        em.close();
    }
}
