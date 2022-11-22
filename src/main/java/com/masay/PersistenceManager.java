package com.masay;

import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Persistence;

public class PersistenceManager {


    private static EntityManager entityManager;

    static {

        try{

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("masay");

            entityManager = emf.createEntityManager();

        } catch (Exception e){

            System.out.println(e);

        }

    }

    public static EntityManager getEntityManager(){ return entityManager; }


    public  static  void closeEntityManger(){ entityManager.close(); }

}
