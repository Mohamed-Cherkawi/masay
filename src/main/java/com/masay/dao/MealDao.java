package com.masay.dao;

import com.masay.entity.Meal;
import com.masay.entity.Restaurant;
import com.masay.utils.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class MealDao {

    private EntityManager em = PersistenceManager.getEntityManager();

    public Meal addMeal(Meal meal) {

        em.getTransaction().begin();

        em.persist(meal);

        em.getTransaction().commit();

        return  meal;

    }

    public Meal getMealById(Integer id){

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT meal FROM Meal meal  where meal.id = :id ", Restaurant.class);

        query.setParameter("id",id);

        Meal meal = (Meal) query.getSingleResult();

        em.getTransaction().commit();

        return meal;

    }

    public  List<Meal> getAllMealsByRestaurantId(Integer id){


        em.getTransaction().begin();

        Query query = em.createQuery("SELECT meal FROM Meal meal  where meal.restaurant.id = :id ", Restaurant.class);

        query.setParameter("id",id);

        em.getTransaction().commit();

        return query.getResultList();

    }

}
