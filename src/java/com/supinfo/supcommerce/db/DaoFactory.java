/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.db;

import com.supinfo.supcommerce.db.daos.CategoryDao;
import com.supinfo.supcommerce.db.daos.jpa.JpaCategoryDao;

/**
 *
 * @author Alexis
 */
public class DaoFactory {
    private DaoFactory() {}
    
    public static CategoryDao getCategoryDao() {
        return new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
    }
}
