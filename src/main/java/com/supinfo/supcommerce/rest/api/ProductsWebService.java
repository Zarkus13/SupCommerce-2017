/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.rest.api;

import com.supinfo.supcommerce.db.DaoFactory;
import com.supinfo.supcommerce.db.PersistenceManager;
import com.supinfo.supcommerce.entities.Product;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Alexis
 */
@Path("/products")
public class ProductsWebService {
    
    @GET @Path("/{id}") @Produces(MediaType.APPLICATION_JSON)
    public Product test(@PathParam("id") Long id) {
        final Product p = DaoFactory.getProductDao().findProductById(id);
        
        return p;
    }
    
}
