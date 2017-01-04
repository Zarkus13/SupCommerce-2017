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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexis
 */
@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Long id = Long.parseLong(req.getParameter("id"));
        
        final SupProduct sp = SupProductDao.findProductById(id);
        final PrintWriter out = resp.getWriter();
        
        out.println("[");
        
        out.println("{");
        out.println("id: " + sp.getId());
        out.println("name: " + sp.getName());
        out.println("content: " + sp.getContent());
        out.println("price: " + sp.getPrice());
        out.println("}");
        
        out.println("]");   
        
    }    
    
}
