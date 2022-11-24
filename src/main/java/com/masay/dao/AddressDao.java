package com.masay.dao;

import com.masay.util.PersistenceManager;

import com.masay.entity.Address;
import jakarta.persistence.EntityManager;

public class AddressDao {

    private EntityManager em = PersistenceManager.getEntityManager();

    public void addAddress(Address address) {
        try {
            em.getTransaction().begin();

            em.persist(address);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
