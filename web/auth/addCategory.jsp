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
        <title>Ajouter une catégorie</title>
    </head>
    <body>
        <jsp:include page="/blocks/header.jsp" />
        <h1>Ajouter une catégorie :</h1>
        
        <form method="POST" action="${pageContext.request.contextPath}/auth/addCategory">
            <label for="name">Nom :</label> <input type="text" id="name" name="name" /> <br>
            <input type="submit" value="Ajouter la catégorie" />
        </form>
    </body>
</html>
