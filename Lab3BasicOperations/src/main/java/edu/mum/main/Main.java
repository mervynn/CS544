package edu.mum.main;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        User user = new User();
        user.setAdmin(true);
        user.setEmail("adam@google.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setRating(100);
        // add a new user
        userService.save(user);

        // find by email
        System.out.println("111");
        User userFind = userService.findByEmail("adam@google.com");
        System.out.println("222");
        User asdf = userService.findByEmail("adam@google.com");
        System.out.println("333");
        System.out.println("         *************  User **************");
        System.out.println("User Name:" + userFind.getFirstName() + " " + userFind.getLastName());

        // update user
        userFind.setFirstName("UpdatedFirstName");
        User u = userService.update(userFind);

        // find by email
        User userFind1 = userService.findByEmail("adam@google.com");
        System.out.println("         *************  User **************");
        System.out.println("User Name:" + userFind1.getFirstName() + " " + userFind1.getLastName());

        // update user -> StaleObjectStateException
//        userFind.setFirstName("UpdatedFirstName+++++");
//        userService.update(userFind);

        // u is returned from EntityManager.merge, it's managed entity.
        u.setFirstName("!!!!!");
        userService.update(u);

        // To test flush and refresh
        // create new Entity Manager
        EntityManager em = userService.getEntityManager();
        EntityManagerFactory emf = em.getEntityManagerFactory();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.getEntityManagerFactory();
        User a = em.find(User.class, 1l);
        System.out.println(a.getFirstName());
        a.setFirstName("?????");
        System.out.println("Managed entity has been updated, but not committed yet.");
        em.flush();
        System.out.println("After flash: " + a.getFirstName());
        a.setFirstName("Can you refresh me out?");
        System.out.println(a.getFirstName());
        em.refresh(a);
        System.out.println("After refresh: " + a.getFirstName());
        System.out.println("Did you see my FirstName? Naive, young man!");
        em.getTransaction().commit();
        System.out.println(111);
        em.find(User.class, 1L);
        System.out.println(222);
        em.find(User.class, 1L);
        System.out.println(333);
        userService.findByEmail("adam@google.com");
        userService.findByEmail("adam@google.com");
        em.close();
    }


}