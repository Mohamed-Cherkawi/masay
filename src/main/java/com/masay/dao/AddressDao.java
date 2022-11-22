package com.masay.dao;

import com.masay.PersistenceManager;

import com.masay.entity.Address;
import com.masay.entity.Operator;
import jakarta.persistence.EntityManager;

public class AddressDao {

    private EntityManager em = PersistenceManager.getEntityManager();


    public Address addAddress(Address address) {

        em.getTransaction().begin();

        em.persist(address);

        em.getTransaction().commit();

        return  address;

    }


}
