<%--
  Created by IntelliJ IDEA.
  User: Téo
  Date: 04/05/2021
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-xxl navbar-dark bg-dark" >
    <a class="navbar-brand" href="accueil">ENI-Encheres</a>

    <c:if test="${sessionScope.connectedUser != null}">
        <div class="navbar-text">
            <a class="mr-2" href="inscription">${sessionScope.connectedUser.pseudo}</a>
            <a  href="connexion">Se déconnecter</a>
        </div>
    </c:if>

    <c:if test="${sessionScope.connectedUser == null}">
        <div class="navbar-text">
            <a class="mr-2" href="inscription">S'inscrire</a>
            <a  href="connexion">Se connecter</a>
        </div>
    </c:if>





</nav>