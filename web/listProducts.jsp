<%-- 
    Document   : listProducts
    Created on : 9 janv. 2017, 11:42:33
    Author     : Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <jsp:include page="/blocks/header.jsp" />
        
        <h1>Liste des produits :</h1>

        <table>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prix</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                    <td><a href="${pageContext.request.contextPath}/showProduct?id=${p.id}">Voir</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>