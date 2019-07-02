package edu.mum.cs544;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        EntityGraph<Owner> graph = em.createEntityGraph(Owner.class);
//        graph.addAttributeNodes("pets");
        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);
//        query.setHint("javax.persistence.fetchgraph", graph);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
        System.exit(0);
    }

}
