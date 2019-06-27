package edu.mum.dao;

import edu.mum.domain.User;

import javax.persistence.EntityManager;

public interface UserDao extends GenericDao<User> {
      
	User findByEmail(String email);
	EntityManager getEntityManager();
}
