package edu.mum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        // TEST A)
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Laptop laptop1 = new Laptop();
        Laptop laptop2 = new Laptop();
        Employee employee = new Employee("emp1");
        employee.addLaptop(laptop1);
        employee.addLaptop(laptop2);
        em.persist(employee);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
        List<Employee> empList = query.getResultList();
        for (Employee e : empList) System.out.println(e);
        em.getTransaction().commit();
        em.close();

        // TEST B)
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Flight f1 = new Flight(null, "A1011", "B", "C");
        Flight f2 = new Flight(null, "C1012", "C", "D");
        Passenger p = new Passenger(null, "Jason Smith", Arrays.asList(f1, f2));
        em.persist(p);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        Passenger pp = em.find(Passenger.class, 1L);
        System.out.println(pp);
        em.getTransaction().commit();
        em.close();

        // TEST C)
        em = emf.createEntityManager();
        em.getTransaction().begin();
        final Student student1 = new Student(10, "May");
        final Student student2 = new Student(20, "June");
        School school = new School(null, "Maharishi University of Management",
                new HashMap<Integer, Student>(){{put(10, student1); put(20, student2);}});
        em.persist(school);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        School school1 = em.find(School.class, 1);
        System.out.println(school1);
        em.getTransaction().commit();
        em.close();
    }
}

