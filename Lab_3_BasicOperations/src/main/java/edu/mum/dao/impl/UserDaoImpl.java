package edu.mum.dao.impl;


import edu.mum.dao.GenericDao;
import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    public User findByEmail(String email) {
        Query query = entityManager.createQuery("select u from users u  where u.email =:email");
        System.out.println(entityManager);
        return (User) query.setParameter("email", email).getSingleResult();
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }


}