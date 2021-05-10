<%--
  Created by IntelliJ IDEA.
  User: Téo
  Date: 04/05/2021
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Mon profil</title>
    <link rel="icon" href="favicon.ico" />
    <jsp:include page="bootstrap_fragment.jsp"></jsp:include>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="error_fragment.jsp"></jsp:include>

<h1>Modification de profil</h1>

    <div class="container h-100">
        <h1 class="text-center">Mon profil</h1>
        <div class="d-flex flex-column justify-content-between">
            <div class="d-flex justify-content-between">
                <div class="d-flex flex-column justify-content-between">
                    <div class="form-group d-flex justify-content-between">
                        <label for="pseudo">Pseudo:</label>
                        <input type="text" name="pseudo" id="pseudo" placeholder="Pseudo" value="${sessionScope.connectedUser.pseudo}">
                    </div>
                    <div class="form-group d-flex justify-content-between">
                        <label for="prenom">Prénom:</label>
                        <input type="text" name="prenom" id="prenom" placeholder="Prénom" value="${sessionScope.connectedUser.prenom}">
                    </div>
                    <div class="form-group d-flex justify-content-between">
                        <label for="telephone">Téléphone:</label>
                        <input type="text" name="telephone" id="telephone" placeholder="Téléphone" value="${sessionScope.connectedUser.telephone}">
                    </div>
                    <div class="form-group d-flex justify-content between">
                        <label for="code_postal">Code Postal:</label>
                        <input type="text" name="code_postal" id="code_postal" placeholder="Code postal" value="${sessionScope.connectedUser.code_postal}">
                    </div>
                    <div class="form-group d-flex justify-content-between">
                        <label for="ancien_mot_de_passe">Saisir votre mot de passe actuel:</label>
                        <input type="password" name="mot_de_passe" id="ancien_mot_de_passe" placeholder="Mot de passe">
                    </div>
                    <div class="form-group d-flex justify-content-between">
                        <label for="nouveau_mot_de_passe">Nouveau Mot de passe:</label>
                        <input type="password" name="mot_de_passe" id="nouveau_mot_de_passe" placeholder="Mot de passe">
                    </div>
                </div>
                <div class="d-flex flex-column justify-content-between">
                    <div class="form-group  d-flex justify-content-between">
                        <label for="nom">Nom:</label>
                        <input type="text" name="nom" placeholder="Nom" id="nom" value="${sessionScope.connectedUser.nom}">
                    </div>
                    <div class="form-group d-flex justify-content-between">
                        <label for="email">Email:</label>
                        <input type="email" name="email" placeholder="Email" id="email" value="${sessionScope.connectedUser.email}">
                    </div>
                    <div class="form-group d-flex justify-content-between">
                        <label for="rue">Rue:</label>
                        <input type="text" name="rue" placeholder="Rue" id="rue" value="${sessionScope.connectedUser.rue}">
                    </div>
                    <div class="form-group d-flex justify-content-between">
                        <label for="ville">Ville:</label>
                        <input type="text" name="ville" placeholder="Ville" id="ville" value="${sessionScope.connectedUser.ville}">
                    </div>
                    <div class="form-group d-flex justify-content-between">
                        <label for="confirmation">Confirmation:</label>
                        <input type="password" name="confirmation" placeholder="Confirmation" id="confirmation">
                    </div>
                </div>
            </div>
            <div class="form-group d-flex justify-content-around">
                <button onclick="modification()" class="btn btn-success" id="modifier">Enregistrer</button>
                <button class="btn btn-info" onclick="supprimer()">Supprimer mon compte</button>
            </div>
        </div>
    </div>


<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
    function modification() {
        let no_utilisateur ='${sessionScope.connectedUser.no_utilisateur}';
        let pseudo = $("#pseudo").val();
        let prenom = $("#prenom").val();
        let nom = $("#nom").val();
        let email = $("#email").val();
        let code_postal = $("#code_postal").val();
        let rue = $("#rue").val();
        let ville = $("#ville").val();
        let telephone = $("#telephone").val();
        let mot_de_passe = $("#mot_de_passe").val();
        let nouveau_mot_de_passe = $("#nouveau_mot_de_passe").val();
        let ancien_mot_de_passe = $("#ancien_mot_de_passe").val();
        let confirmation = $("#confirmation").val();
        let btn_creer = $("#modifier");

      if (confirmation != nouveau_mot_de_passe) {
          //TODO Notifier
            alert("Le mot de passe doit correspondre à la confirmation");
        }else{
            $.ajax({
                error: function (data) {
                    console.log("data", data);

                    notifier(data.responseJSON.title,data.responseJSON.message)
                },

                type:"PUT",
                data:{pseudo: pseudo, prenom: prenom, nom: nom, email: email, telephone: telephone, code_postal: code_postal, ville: ville, rue: rue, nouveau_mot_de_passe: nouveau_mot_de_passe, ancien_mot_de_passe: ancien_mot_de_passe},
                url: "http://localhost:8080/troc_encheres_groupe_1/api/utilisateur/modification/"+no_utilisateur,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function(data){
                   window.location = 'accueil';
                    console.log(data)},
            });
        }
    }
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


</body>
</html>


