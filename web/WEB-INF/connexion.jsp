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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<h1>ENI - Enchères</h1>


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
            /*success: function (data) {
                        alert("Bien envoyé");

                        console.log("utilisateur", JSON.stringify(data));
                    }
                })
            },
            error: function (data) {
                console.log("login", login, "mot de passe", password);
                console.log("data", data);
                alert("Utilisateur non trouvé");
            }*/

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
                });
            }
        });
    }

</script>
</body>
</html>


