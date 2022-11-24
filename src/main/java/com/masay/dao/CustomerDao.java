package com.masay.dao;

import com.masay.entity.Customer;
import com.masay.entity.User;
import com.masay.util.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class CustomerDao {
    private EntityManager em = PersistenceManager.getEntityManager();

    public Customer addCustomer(Customer customer) {
        try{
            em.getTransaction().begin();

            em.persist(customer);

            em.getTransaction().commit();

        }catch ( Exception e ){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return customer;
    }

    public User getCustomerByEmail(String email){
        try {
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT customer FROM Customer customer  WHERE customer.email = :email ", Customer.class);

            query.setParameter("email", email);

            Customer customer = (Customer) query.getSingleResult();

            em.getTransaction().commit();

            return customer;
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        return null;
    }
}
