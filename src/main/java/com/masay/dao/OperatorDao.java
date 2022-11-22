package com.masay.dao;

import com.masay.entity.User;
import com.masay.utils.PersistenceManager;
import com.masay.entity.Operator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class OperatorDao {

    private EntityManager em = PersistenceManager.getEntityManager();

    public Operator addOperator(Operator operator) {

        em.getTransaction().begin();

        em.persist(operator);

        em.getTransaction().commit();

        return  operator;

    }


    public User getOperatorByEmail(String email){

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT operator FROM Operator operator  where operator.email = :email ", Operator.class);

        query.setParameter("email",email);

        Operator operator = (Operator) query.getSingleResult();

        em.getTransaction().commit();

        return operator;

    }


}
