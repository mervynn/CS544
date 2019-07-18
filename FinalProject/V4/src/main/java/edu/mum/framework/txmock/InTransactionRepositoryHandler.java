package edu.mum.framework.txmock;

import edu.mum.framework.util.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InTransactionRepositoryHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        if (args == null || args.length == 0) return em.createQuery("from Book").getResultList();
        return em.merge(args[0]);
    }
}
