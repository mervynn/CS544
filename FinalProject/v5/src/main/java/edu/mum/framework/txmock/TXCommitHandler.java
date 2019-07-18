package edu.mum.framework.txmock;

import edu.mum.framework.util.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TXCommitHandler implements InvocationHandler {
    private Object obj;
    public TXCommitHandler(Object o){
        this.obj = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object ret = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            em.getTransaction().begin();
            ret = method.invoke(obj, args);
            em.getTransaction().commit();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
