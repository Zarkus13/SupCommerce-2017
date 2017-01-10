<%-- 
    Document   : addProduct
    Created on : 9 janv. 2017, 12:01:37
    Author     : Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un produit</title>
    </head>
    <body>
        <jsp:include page="/blocks/header.jsp" />
        <h1>Ajouter un produit :</h1>
        
        <form method="POST" action="${pageContext.request.contextPath}/auth/addProduct">
            <label for="name">Nom :</label> <input type="text" id="name" name="name" /> <br>
            <label for="price">Prix :</label> <input type="number" id="price" name="price" /> <br>
            <label for="content">Contenu :</label> <textarea id="content" name="content"></textarea> <br>
            <label for="category">Catégorie :</label>
            <select id="category" name="categoryId">
                <option value="null">Choisissez une catégorie</option>
                <c:forEach items="${categories}" var="c">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </select> <br>
            <input type="submit" value="Ajouter le produit" />
        </form>
    </body>
</html>
