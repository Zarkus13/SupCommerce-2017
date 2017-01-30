/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Alexis
 */
@Path("/products")
public class ProductsWebService {
    
    @GET @Path("/{name}")
    public String test(@PathParam("name") String name) {
        return "Hello " + name;
    }
    
}
