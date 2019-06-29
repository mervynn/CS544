package edu.mum.service.impl;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements edu.mum.service.UserService {

    @Autowired
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }


    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public EntityManager getEntityManager(){
        return userDao.getEntityManager();
    }

}
