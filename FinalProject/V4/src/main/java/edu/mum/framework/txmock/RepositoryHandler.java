package edu.mum.framework.txmock;

import edu.mum.cs544.domain.Book;
import edu.mum.framework.util.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class RepositoryHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        em.getTransaction().begin();
        if (args == null || args.length == 0) {
            List<Book> books = em.createQuery(" from Book", Book.class).getResultList();
            em.getTransaction().commit();
            return books;
        }
        Object book = em.merge(args[0]);
        em.getTransaction().commit();
        return book;
    }
}
