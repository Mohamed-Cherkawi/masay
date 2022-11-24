package com.masay.dao;

import com.masay.entity.Restaurant;

import com.masay.util.PersistenceManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class RestaurantDao {

    private EntityManager em = PersistenceManager.getEntityManager();

    public Restaurant addRestaurant(Restaurant restaurant) {
        try{
            em.getTransaction().begin();

            em.persist(restaurant);

            em.getTransaction().commit();

            return  restaurant;
        }catch ( Exception e ){
            e.printStackTrace();
        }
        return null;
    }
    public List<Restaurant> getAllRestaurants(){

        try {
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT restaurant FROM Restaurant restaurant", Restaurant.class);

            em.getTransaction().commit();
            return query.getResultList();
        } catch ( Exception e ){
            System.out.println("The Problem is here");
            e.printStackTrace();
        }
        return null;
    }
    public Restaurant getRestaurantById(int id){
        try {
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT restaurant FROM Restaurant restaurant WHERE restaurant.id = :id", Restaurant.class);
            query.setParameter("id",id);
            em.getTransaction().commit();

            return (Restaurant) query.getSingleResult();
        } catch ( Exception e ){
            return null;
        }

    }
    public boolean checkIfRestoExistsById(int id){
        try {
            em.getTransaction().begin();

            Query query = em.createNativeQuery("SELECT id FROM restaurants WHERE id = ?");
            query.setParameter(1,id);
            em.getTransaction().commit();
                return true;

        } catch ( Exception e ){
            return false;
        }
    }

}