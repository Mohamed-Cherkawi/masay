package com.masay.dao;

import com.masay.entity.Deliverer;
import com.masay.entity.Operator;
import com.masay.entity.User;
import com.masay.utils.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class DelivererDao {

    private EntityManager em = PersistenceManager.getEntityManager();

    public Deliverer addDeliverer(Deliverer deliverer) {

        em.getTransaction().begin();

        em.persist(deliverer);

        em.getTransaction().commit();

        return  deliverer;

    }


    public User getDelivererByEmail(String email){

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT deliverer FROM Deliverer deliverer where deliverer.email = :email ", Operator.class);

        query.setParameter("email",email);

        Deliverer deliverer = (Deliverer) query.getSingleResult();

        em.getTransaction().commit();

        return deliverer;

    }
}
