package com.masay.dao;

import com.masay.entity.Restaurant;

import com.masay.entity.User;
import com.masay.utils.PersistenceManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class RestaurantDao {

    private EntityManager em = PersistenceManager.getEntityManager();

    public Restaurant addRestaurant(Restaurant restaurant) {

        em.getTransaction().begin();

        em.persist(restaurant);

        em.getTransaction().commit();

        return  restaurant;

    }

    public List<Restaurant> getAllRestaurants(){

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT restaurant FROM Restaurant restaurant", Restaurant.class);

        em.getTransaction().commit();

        return query.getResultList();

    }

}
