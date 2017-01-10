/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

import com.supinfo.supcommerce.db.DaoFactory;
import com.supinfo.supcommerce.entities.Category;
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
@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Category> categories = DaoFactory.getCategoryDao().listAllCategories();
        req.setAttribute("categories", categories);
        
        req.getRequestDispatcher("/auth/addProduct.jsp")
            .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final Float price = Float.parseFloat(req.getParameter("price"));
        final String content = req.getParameter("content");
        final Long categoryId = Long.parseLong(req.getParameter("categoryId"));
        
        final Product p = new Product(name, price, content);
        p.setCategory(
            DaoFactory.getCategoryDao().findCategoryById(categoryId)
        );
        
        DaoFactory.getProductDao().addProduct(p);
        
        resp.sendRedirect(req.getContextPath() + "/showProduct?id=" + p.getId());
    }
    
    
}
