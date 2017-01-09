<%-- 
    Document   : header
    Created on : 9 janv. 2017, 12:15:28
    Author     : Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header">
    <a href="${pageContext.request.contextPath}/listProducts">
        Liste des produits
    </a> | 
    <c:if test="${!empty sessionScope.username}">
        <a href="${pageContext.request.contextPath}/auth/addProduct">
        Ajouter un produit
        </a> | 
        <a href="${pageContext.request.contextPath}/logout">
            Déconnexion
        </a> | 
    </c:if>
    <c:if test="${empty sessionScope.username}">
        <a href="${pageContext.request.contextPath}/login">
            Se connecter
        </a>
    </c:if>
</div>
