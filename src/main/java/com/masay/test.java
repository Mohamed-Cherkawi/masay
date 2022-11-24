package com.masay;

import com.masay.util.PersistenceManager;
import jakarta.persistence.EntityManager;

public class test {

    public static void main(String[] args) {
        EntityManager em = PersistenceManager.getEntityManager();

    }
}
