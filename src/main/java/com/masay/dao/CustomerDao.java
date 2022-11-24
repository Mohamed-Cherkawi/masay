package com.masay.dao;

import com.masay.entity.Customer;
import com.masay.entity.Operator;
import com.masay.entity.User;
import com.masay.utils.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class CustomerDao {

    private EntityManager em = PersistenceManager.getEntityManager();

    public Customer addCustomer(Customer customer) {

        em.getTransaction().begin();

        em.persist(customer);

        em.getTransaction().commit();

        return  customer;

    }


    public Customer updateCustomer(Customer customer) {

        em.getTransaction().begin();

        em.merge(customer);

        em.getTransaction().commit();

        return  customer;

    }


    public Customer getCustomerByEmail(String email){

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT customer FROM Customer customer  where customer.email = :email ", Customer.class);

        query.setParameter("email",email);

        Customer customer = (Customer) query.getSingleResult();

        em.getTransaction().commit();

        return customer;

    }
}
