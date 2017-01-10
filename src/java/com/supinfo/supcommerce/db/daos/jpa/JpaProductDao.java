/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.db.daos.jpa;

import com.supinfo.supcommerce.db.JpaDao;
import com.supinfo.supcommerce.db.daos.ProductDao;
import com.supinfo.supcommerce.entities.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alexis
 */
public class JpaProductDao extends JpaDao implements ProductDao {

    public JpaProductDao(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Product addProduct(Product product) {
        return withTransaction((EntityManager em) -> {
            em.persist(product);
            
            return product;
        });
    }
    
}
