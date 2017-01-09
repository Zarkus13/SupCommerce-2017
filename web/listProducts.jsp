<%-- 
    Document   : listProducts
    Created on : 9 janv. 2017, 11:42:33
    Author     : Alexis
--%>

<%@page import="com.supinfo.sun.supcommerce.doa.SupProductDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des produits</title>
    </head>
    <body>
        <%@include file="/blocks/header.jsp" %>
        <h1>Liste des produits :</h1>

        <table>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prix</th>
                <th>Actions</th>
            </tr>
            <% for(SupProduct sp : SupProductDao.getAllProducts()) { %>
                <tr>
                    <td><%= sp.getId() %></td>
                    <td><%= sp.getName() %></td>
                    <td><%= sp.getPrice() %></td>
                    <td><a href="<%= request.getServletContext().getContextPath() %>/showProduct.jsp?id=<%= sp.getId() %>">Voir</a></td>
                </tr>	
            <% } %>		
        </table>
    </body>
</html>