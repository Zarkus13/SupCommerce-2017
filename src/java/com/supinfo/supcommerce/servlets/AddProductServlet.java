/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexis
 */
@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        final SupProduct sp = new SupProduct();
        sp.setName(req.getParameter("name"));
        sp.setPrice(Float.parseFloat(req.getParameter("price")));
        sp.setContent(req.getParameter("content"));
        
        SupProductDao.addProduct(sp);
        
        resp.sendRedirect(req.getContextPath() + "/showProduct.jsp?id=" + sp.getId());
    }
    
    
    
}
