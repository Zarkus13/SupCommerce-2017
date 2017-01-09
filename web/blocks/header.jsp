<%-- 
    Document   : header
    Created on : 9 janv. 2017, 12:15:28
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header">
    <a href="<%= request.getContextPath() %>/listProducts.jsp">
        Liste des produits
    </a> | 
    <% if(session.getAttribute("username") != null) { %>
    <a href="<%= request.getContextPath() %>/auth/addProduct.jsp">
        Ajouter un produit
    </a> | 
    <a href="<%= request.getContextPath() %>/logout">
        Déconnexion
    </a> | 
    <% } else { %>
    <a href="<%= request.getContextPath() %>/login.html">
        Se connecter
    </a>
    <% } %>
</div>
