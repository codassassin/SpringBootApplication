package com.codassassin.tourmanagement.repository.impl;

import com.codassassin.tourmanagement.model.User;
import com.codassassin.tourmanagement.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public abstract class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByUsername(String userName) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.username=:userName");
        query.setParameter("userName", userName);
        List<User> userList = query.getResultList();
        if(userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public User getUserById(long userId) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.id=:userId");
        query.setParameter("userId", userId);
        List<User> userList = query.getResultList();
        if(userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public void deleteUserById(long userId) {
        Query query = entityManager.createQuery("DELETE u FROM User u WHERE u.id=:userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }
}
