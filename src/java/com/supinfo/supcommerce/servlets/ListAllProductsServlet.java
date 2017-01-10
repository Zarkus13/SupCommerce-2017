/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

import com.supinfo.supcommerce.db.DaoFactory;
import com.supinfo.supcommerce.entities.Product;
import java.io.IOException;
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
        final List<Product> products = DaoFactory.getProductDao().listAllProducts();
        req.setAttribute("products", products);
        
        req.getRequestDispatcher("/listProducts.jsp")
            .forward(req, resp);
    }       
    
}
