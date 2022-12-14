package com.masay.dao;

import com.masay.entity.User;
import com.masay.util.PersistenceManager;
import com.masay.entity.Operator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class OperatorDao {

    private EntityManager em = PersistenceManager.getEntityManager();

    public Operator addOperator(Operator operator) {
        try{
            em.getTransaction().begin();

            em.persist(operator);

            em.getTransaction().commit();

        }catch ( Exception e ){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return operator;
    }

    public User getOperatorByEmail(String email){
        try {
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT operator FROM Operator operator  WHERE operator.email = :email ", Operator.class);

            query.setParameter("email", email);

            Operator operator = (Operator) query.getSingleResult();

            em.getTransaction().commit();

            return operator;
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        return null;
    }


}
