/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.db.daos;

import com.supinfo.supcommerce.entities.Product;

/**
 *
 * @author Alexis
 */
public interface ProductDao {
    
    Product addProduct(final Product product);
    
}
