<%-- 
    Document   : addProduct
    Created on : 9 janv. 2017, 12:01:37
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un produit</title>
    </head>
    <body>
        <%@include file="/blocks/header.jsp" %>
        <h1>Ajouter un produit :</h1>
        
        <form method="POST" action="<%= application.getContextPath() %>/auth/addProduct">
            <label for="name">Nom :</label> <input type="text" id="name" name="name" /> <br>
            <label for="price">Prix :</label> <input type="number" id="price" name="price" /> <br>
            <label for="content">Contenu :</label> <textarea id="content" name="content"></textarea> <br>
            <input type="submit" value="Ajouter le produit" />
        </form>
    </body>
</html>
