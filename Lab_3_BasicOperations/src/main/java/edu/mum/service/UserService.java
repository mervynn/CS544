package edu.mum.service;

import java.util.List;

import edu.mum.domain.User;

import javax.persistence.EntityManager;

public interface UserService {

	void save(User user);
	List<User> findAll();
	User findByEmail(String email);
	User update(User user);

	// for Testing flush and refresh
	EntityManager getEntityManager();
}
