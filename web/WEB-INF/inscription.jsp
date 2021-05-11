<%--
  Created by IntelliJ IDEA.
  User: igali
  Date: 04/05/2021
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Inscription</title>
    <jsp:include page="bootstrap_fragment.jsp"></jsp:include>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="error_fragment.jsp"></jsp:include>
<div class="container h-100">
    <h1 class="text-center">Mon profil</h1>
    <div class="d-flex flex-column justify-content-between">
        <div class="d-flex justify-content-between">
            <div class="d-flex flex-column justify-content-between">
                <div class="form-group d-flex justify-content-between">
                    <label for="pseudo">Pseudo:</label>
                    <input type="text" name="pseudo" id="pseudo" placeholder="Pseudo">
                </div>
                <div class="form-group d-flex justify-content-between">
                    <label for="prenom">Prénom:</label>
                    <input type="text" name="prenom" id="prenom" placeholder="Prénom">
                </div>
                <div class="form-group d-flex justify-content-between">
                    <label for="telephone">Téléphone:</label>
                    <input type="text" name="telephone" id="telephone" placeholder="Téléphone">
                </div>
                <div class="form-group d-flex justify-content between">
                    <label for="code_postal">Code Postal:</label>
                    <input type="text" name="code_postal" id="code_postal" placeholder="Code postal">
                </div>
                <div class="form-group d-flex justify-content-between">
                    <label for="mot_de_passe">Mot de passe:</label>
                    <input type="password" name="mot_de_passe" id="mot_de_passe" placeholder="Mot de passe">
                </div>
            </div>
            <div class="d-flex flex-column justify-content-between">
                <div class="form-group  d-flex justify-content-between">
                    <label for="nom">Nom:</label>
                    <input type="text" name="nom" placeholder="Nom" id="nom">
                </div>
                <div class="form-group d-flex justify-content-between">
                    <label for="email">Email:</label>
                    <input type="email" name="email" placeholder="Email" id="email">
                </div>
                <div class="form-group d-flex justify-content-between">
                    <label for="rue">Rue:</label>
                    <input type="text" name="rue" placeholder="Rue" id="rue">
                </div>
                <div class="form-group d-flex justify-content-between">
                    <label for="ville">Ville:</label>
                    <input type="text" name="ville" placeholder="Ville" id="ville">
                </div>
                <div class="form-group d-flex justify-content-between">
                    <label for="confirmation">Confirmation:</label>
                    <input type="password" name="confirmation" placeholder="Confirmation" id="confirmation">
                    <!-- <span class="error_mot_de_passe"></span> -->
                </div>
            </div>
        </div>
        <div class="form-group d-flex justify-content-around">
            <button onclick="inscription()" class="btn btn-success" id="creer">Créer</button>
            <a href="#" class="btn btn-danger" onclick="window.location.href='accueil.jsp'">Annuler</a>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
    function inscription() {
        let pseudo = $("#pseudo").val();
        let prenom = $("#prenom").val();
        let nom = $("#nom").val();
        let email = $("#email").val();
        let code_postal = $("#code_postal").val();
        let rue = $("#rue").val();
        let ville = $("#ville").val();
        let telephone = $("#telephone").val();
        let confirmation = $("#confirmation").val();
        let mot_de_passe = $("#mot_de_passe").val();
        let btn_creer = $("#creer");
        //let error_mot_de_passe = $(".error_mot_de_passe");

        if (pseudo == null) {
            btn_creer.disabled = true;
        }

        //console.log(error_mot_de_passe);
        if (confirmation != mot_de_passe) {
            alert("Le mot de passe doit correspondre à la confirmation");
            //error_mot_de_passe.text("Le mot de passe doit correspondre à la confirmation");
        } else {
            $.ajax({
                type: "POST",
                data: {
                    pseudo: pseudo,
                    prenom: prenom,
                    nom: nom,
                    email: email,
                    telephone: telephone,
                    code_postal: code_postal,
                    ville: ville,
                    rue: rue,
                    mot_de_passe: mot_de_passe
                },
                url: "http://localhost:8080/troc_encheres_groupe_1/api/utilisateur/inscription",
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function (data) {
                    connexion(pseudo, mot_de_passe)
                },
                error: function (data) {
                    console.log("data", data);

                    notifier(data.responseJSON.title, data.responseJSON.message)
                }
            });
        }
    }

    function connexion(pseudo, mot_de_passe) {
        let login = pseudo;
        let password = mot_de_passe;
        $.ajax({

            error: function (data) {
                console.log("login", login, "mot de passe", password);
                console.log("data", data);
                alert("Login ou mot de pase incorrect");
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
                    success: function (data) {
                        window.location = 'accueil'
                    }
                });
            }
        });
    }
</script>
</body>

</html>