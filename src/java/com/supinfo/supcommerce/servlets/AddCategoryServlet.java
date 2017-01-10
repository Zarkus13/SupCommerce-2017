/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

import com.supinfo.supcommerce.db.DaoFactory;
import com.supinfo.supcommerce.entities.Category;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexis
 */
@WebServlet(urlPatterns = "/auth/addCategory" )
public class AddCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final Category category = new Category();
        category.setName(name);
        
        DaoFactory.getCategoryDao().addCategory(category);
        
        resp.sendRedirect(getServletContext().getContextPath() + "/auth/addCategory");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth/addCategory.jsp")
            .forward(req, resp);
    }
    
    
    
}
