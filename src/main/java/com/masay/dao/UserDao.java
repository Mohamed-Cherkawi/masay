package com.masay.dao;

import com.masay.PersistenceManager;
import com.masay.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class UserDao {

    private EntityManager em = PersistenceManager.getEntityManager();

    public List<User> getAllUsers(){

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT user FROM User user", User.class);

        em.getTransaction().commit();

        return query.getResultList();

    }

}
