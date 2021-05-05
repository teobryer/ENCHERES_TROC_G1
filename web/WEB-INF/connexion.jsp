<%--
  Created by IntelliJ IDEA.
  User: Valentin
  Date: 04/05/2021
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Connexion</title>
    <jsp:include page="bootstrap_fragment.jsp"></jsp:include>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="error_fragment.jsp"></jsp:include>


<div class="form-group">
    <label for="login">Identifiant / Email</label>
    <input type="text" class="form-control" id="login"
           placeholder="Entrez votre identifiant ou votre email">
</div>
<div class="form-group">
    <label for="password">Mot de passe</label>
    <input type="password" class="form-control" id="password" placeholder="Mot de passe">
</div>
<div class="form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck">
    <label class="form-check-label" for="exampleCheck">Se souvenir de moi</label>
</div>
<button class="btn btn-info" onclick="connexion()">Connexion</button>
<a href="accueil.jsp">Mot de passe oublié</a>
<button type="button" class="btn btn-dark btn-lg" onclick="window.location.href='accueil.jsp'">Créer un compte</button>
<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
    function connexion() {
        let login = $("#login").val();
        let password = $("#password").val();
        $.ajax({

            error: function (data) {
                console.log("data", data);

                notifier(data.responseJSON.title,data.responseJSON.message)
            },

            type: "POST",
            dataType: "json",
            data: {login: login, password: password},
            url: "http://localhost:8080/troc_encheres_groupe_1/api/utilisateur/connexion",
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (data) {
                console.log("data", data);
                $.ajax({
                    type: "POST",
                    data: {utilisateur: JSON.stringify(data)},
                    url: "accueil",
                    success: function(data){
                        window.location = 'accueil'}
                });
            }
        });
    }

</script>
</body>
</html>


