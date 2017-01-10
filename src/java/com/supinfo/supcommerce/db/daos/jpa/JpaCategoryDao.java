/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.db.daos.jpa;

import com.supinfo.supcommerce.db.PersistenceManager;
import com.supinfo.supcommerce.db.daos.CategoryDao;
import com.supinfo.supcommerce.entities.Category;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Alexis
 */
public class JpaCategoryDao implements CategoryDao {
    private EntityManagerFactory emf;
    
    public JpaCategoryDao(final EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Category addCategory(final Category category) {
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction t = em.getTransaction();
        
        try {
            t.begin();
            
            em.persist(category);
            
            t.commit();
            
            return category;
        } catch(Exception e) {
            return null;
        } finally {
            if(t.isActive())
                t.rollback();
            
            em.close();
        }
    }
    
}
