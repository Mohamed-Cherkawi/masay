package com.masay.util;

import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Persistence;

public class PersistenceManager {

    private static EntityManager entityManager = null;

    public static EntityManager getEntityManager(){
        if ( entityManager == null ){
            try{

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("masay");

                entityManager = emf.createEntityManager();

            } catch (Exception e){

                e.printStackTrace();

            }
        }
        return entityManager;
    }

    public  static  void closeEntityManger(){
        if( entityManager != null )
        entityManager.close();

        entityManager = null;
    }

}
