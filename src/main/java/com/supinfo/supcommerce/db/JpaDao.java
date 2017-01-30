/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.db;

import java.util.function.Function;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Alexis
 */
public abstract class JpaDao {
    private EntityManagerFactory emf;

    public JpaDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    protected <T> T withEntityManager(final Function<EntityManager, T> func) {
        final EntityManager em = emf.createEntityManager();
        
        try {
            return func.apply(em);
        } catch(Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    protected <T> T withTransaction(final Function<EntityManager, T> func) {
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction t = em.getTransaction();
        
        try {
            t.begin();
            
            T ret = func.apply(em);
            
            t.commit();
            
            return ret;
        } catch(Exception e) {
            return null;
        } finally {
            if(t.isActive())
                t.rollback();
            
            em.close();
        }
    }
    
}
