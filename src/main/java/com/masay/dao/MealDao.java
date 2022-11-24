package com.masay.dao;

import com.masay.entity.Meal;
import com.masay.util.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class MealDao {

    private EntityManager em = PersistenceManager.getEntityManager();

    public Meal addMeal(Meal meal){
        try{
            em.getTransaction().begin();

            em.persist(meal);

            em.getTransaction().commit();

            return  meal;
        }catch ( Exception e ){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateMeal(int id , String name , String type , float price , String description){
        try{
            Meal meal = em.find(Meal.class,id);
            meal.setName(name);
            meal.setType(type);
            meal.setPrice(price);
            meal.setDescription(description);
            em.merge(meal);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteMeal(int id){
        try{
            em.remove(em.find(Meal.class,id));
            em.getTransaction().commit();
            return true;
        }catch ( Exception e ){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }
    public List<Meal> getAllMeals(){
        try {
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT meal FROM Meal meal", Meal.class);

            em.getTransaction().commit();

            return query.getResultList();
        } catch ( Exception e ){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return null;
    }
    public boolean isMealIdExists(int id){
        try {
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT meal.id FROM Meal meal WHERE meal.id = :id");
            query.setParameter("id",id);
            return true;
        }catch ( Exception e ){
            return false;
        }
    }

}
