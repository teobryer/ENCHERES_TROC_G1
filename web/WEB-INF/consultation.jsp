<%--
  Created by IntelliJ IDEA.
  User: igali
  Date: 07/05/2021
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="error_fragment.jsp"></jsp:include>
<jsp:include page="bootstrap_fragment.jsp"></jsp:include>

<style>

    .profil ul li{
        list-style: none;
    }
</style>

<div class="container d-flex flex-column justify-content-between align-items-center profil">
    <ul>
        <li class="my-1">Pseudo: ${sessionScope.connectedUser.pseudo}</li>
        <li class="my-1">Nom: ${sessionScope.connectedUser.nom}</li>
        <li class="my-1">Prénom: ${sessionScope.connectedUser.prenom}</li>
        <li class="my-1>Email: ${sessionScope.connectedUser.email}</li>
        <li class="my-1>Téléphone: ${sessionScope.connectedUser.telephone}</li>
        <li class="my-1>Rue: ${sessionScope.connectedUser.rue}</li>
        <li class="my-1>Code Postal: ${sessionScope.connectedUser.code_postal}</li>
        <li class="my-1">Ville: ${sessionScope.connectedUser.ville}</li>
    </ul>
    <a href="profil" class="btn btn-success">Modifier</a>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
