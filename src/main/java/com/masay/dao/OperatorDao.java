package com.masay.dao;

import com.masay.PersistenceManager;
import com.masay.entity.Operator;
import jakarta.persistence.EntityManager;

public class OperatorDao {

    private EntityManager em = PersistenceManager.getEntityManager();

    public Operator addOperator(Operator operator) {

        em.getTransaction().begin();

        em.persist(operator);

        em.getTransaction().commit();

        return  operator;

    }


}
