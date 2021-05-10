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
            <a  class="mr-2"  href="accueil">Enchères</a>
            <a  class="mr-2"  href="vendreArticle">Vendre un article</a>
            <a class="mr-2" href="consultation">${sessionScope.connectedUser.pseudo}</a>
            <a  href="deconnexion">Déconnexion</a>
        </div>
    </c:if>

    <c:if test="${sessionScope.connectedUser == null}">
        <div class="navbar-text">
            <a class="mr-2" href="inscription">S'inscrire</a>
            <a  href="connexion">Se connecter</a>
        </div>
    </c:if>


</nav>


<script>
    function supprimer(){
        let user ='${sessionScope.connectedUser.no_utilisateur}';
      alert(user);
      console.log(user);
        $.ajax({
            type:"DELETE",
            url: "http://localhost:8080/troc_encheres_groupe_1/api/utilisateur/suppression/"+user,
            success: function(){
                notifier("Succès","Votre compte a bien été supprimé");
                window.location = 'accueil';
            },
            error: function (data) {
                console.log("data", data);

                notifier(data.responseJSON.title,data.responseJSON.message)
            }
        });


    }

</script>


