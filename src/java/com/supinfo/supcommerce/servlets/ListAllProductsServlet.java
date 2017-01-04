/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexis
 */
@WebServlet(urlPatterns = "/listProducts")
public class ListAllProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        
        final List<SupProduct> products = SupProductDao.getAllProducts();
        final PrintWriter out = resp.getWriter();
        
        out.println("[");
        
        products.forEach((sp) -> {
            out.println("{");
            out.println("id: " + sp.getId());
            out.println("name: " + sp.getName());
            out.println("price: " + sp.getPrice());
            out.println("},");
        });
        
        out.println("]");        
    }
       
    
}
