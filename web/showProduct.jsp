<%-- 
    Document   : showProduct
    Created on : 9 janv. 2017, 11:56:10
    Author     : Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.supinfo.sun.supcommerce.doa.SupProductDao"%>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produit "${product.name}"</title>
    </head>
    <body>  
        <jsp:include page="/blocks/header.jsp" />
        
        <h1>Produit "${product.name}"</h1>
        
        ID : ${product.id} <br>
        Nom : ${product.name} <br>
        Prix : ${product.price} <br>
        Contenu : ${product.content} <br>
        Catégorie : ${product.category.name}
    </body>
</html>
