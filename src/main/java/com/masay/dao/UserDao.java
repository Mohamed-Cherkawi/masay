package com.masay.dao;

import com.masay.utils.PersistenceManager;
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

    public User getUserByEmail(String email){

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT user FROM User user  where user.email = :email ", User.class);

        query.setParameter("email",email);

        User user = (User) query.getSingleResult();

        em.getTransaction().commit();

        return user;

    }

}
