/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.db.daos.jpa;

import java.util.List;

import com.supinfo.supcommerce.db.JpaDao;
import com.supinfo.supcommerce.db.daos.CategoryDao;
import com.supinfo.supcommerce.entities.Category;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alexis
 */
public class JpaCategoryDao extends JpaDao implements CategoryDao {
    
    public JpaCategoryDao(final EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Category addCategory(final Category category) {
        return withTransaction((EntityManager em) -> {
            em.persist(category);
            
            return category;
        });
    }

    @Override
    public Boolean deleteCategory(final Category category) {
        return withTransaction((EntityManager em) -> {
            em.remove(category);
            
            return true;
        });
    }

    @Override
    public List<Category> listAllCategories() {
        return withEntityManager((EntityManager em) -> {
            return em.createNamedQuery("Category.findAll").getResultList(); // Voir dans classe Category
        });
    }

    @Override
    public Category findCategoryById(Long categoryId) {
        return withEntityManager((EntityManager em) -> {
           return em.find(Category.class, categoryId);
        });
    }
    
}
