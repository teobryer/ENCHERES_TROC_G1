<%--
  Created by IntelliJ IDEA.
  User: Valentin
  Date: 07/05/2021
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Vendre un article</title>
    <jsp:include page="bootstrap_fragment.jsp"></jsp:include>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="error_fragment.jsp"></jsp:include>

<form>
    <div class="col">
        <input type="hidden" id="no_utilisateur">
        <div>
            <label for="nom_article" class="form-label">Article :</label>
            <input type="text" class="form-control" id="nom_article" required>
        </div>
        <div>
            <label for="description" class="form-label">Description :</label>
            <input type="text" class="form-control" id="description" required>
        </div>
        <div>
            <label for="categorie" class="form-label">Catégorie :</label>
            <select class="form-select" aria-label="Catégorie :" id="categorie">
                <option value="1">InformatiqueA MODIFIER</option>
                <option value="2">Ameublement</option>
                <option value="3">Vêtement</option>
                <option value="4">Sport&Loisir</option>
            </select>
        </div>
        <div>
            <label for="photo" class="form-label">Photo de l'article :</label>
            <input type="file" class="form-control" id="photo" accept="image/x-png,image/gif,image/jpeg,image/jpg">
        </div>
        <div>
            <input type="number" class="form-label" id="prix_depart" min="0" required>
            <label class="form-label" for="prix_depart">Mise à prix</label>
        </div>
        <div>
            <input type="datetime-local" class="form-label" id="debut_encheres" required>
            <label class="form-label" for="debut_encheres">Début de la vente</label>
        </div>
        <div>
            <input type="datetime-local" class="form-label" id="fin_encheres" required>
            <label class="form-label" for="debut_encheres">Fin de la vente</label>
        </div>
    </div>


    <%-- PARTIE RETRAIT --%>
    <div class="mb-3">
        <input type="text" class="form-label" id="rue" required>
        <label class="form-label" for="rue">Rue :</label>
    </div>
    <div class="mb-3">
        <input pattern="([0-9]{5})|([0-9][A|B][0-9]{3})" type="text" id="code_postal" required>
        <label class="form-label" for="code_postal">Code postal :</label>
    </div>
    <div class="mb-3">
        <input type="text" class="form-label" id="ville" required>
        <label class="form-label" for="rue">Ville :</label>
    </div>

    <button type="submit" class="btn btn-primary">Enregistrer</button>
    <button type="button" class="btn btn-secondary">Annuler</button>
</form>

<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
    function ajouterArticle() {
        let nom_article = $("#nom_article").val();
        let description = $("#description").val();
        let date_debut_encheres = $("#date_debut_encheres").val();
        let date_fin_encheres = $("#date_fin_encheres").val();
        let prix_initial = $("#prix_initial").val();
        let no_categorie = $("#no_categorie").val();
        let code_postal = $("#code_postal").val();
        let rue = $("#rue").val();
        let ville = $("#ville").val();
        let btn_creer = $("#creer");

        let no_utilisateur = 1;

        $.ajax({
            type: "POST",
            data: {
                nom_article: nom_article,
                description: description,
                date_debut_encheres: date_debut_encheres,
                date_fin_encheres: date_fin_encheres,
                prix_initial: prix_initial,
                no_utilisateur: no_utilisateur,
                no_categorie: no_categorie,
                code_postal: code_postal,
                ville: ville,
                rue: rue
            },
            url: "http://localhost:8080/troc_encheres_groupe_1/api/articles/vendreArticle",
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            error: function (data) {
                console.log("data", data);

                notifier(data.responseJSON.title, data.responseJSON.message)
            }
        });
    }
</script>
</body>
</html>


