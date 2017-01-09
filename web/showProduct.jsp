<%-- 
    Document   : showProduct
    Created on : 9 janv. 2017, 11:56:10
    Author     : Alexis
--%>

<%@page import="com.supinfo.sun.supcommerce.doa.SupProductDao"%>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% final Long id = Long.parseLong(request.getParameter("id")); %>
<% final SupProduct sp = SupProductDao.findProductById(id); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produit "<%= sp.getName() %>"</title>
    </head>
    <body>
        <h1>Produit "<%= sp.getName() %>"</h1>
        
        ID : <%= sp.getId() %> <br>
        Nom : <%= sp.getName() %> <br>
        Prix : <%= sp.getPrice() %> <br>
        Contenu : <%= sp.getContent() %>
    </body>
</html>
