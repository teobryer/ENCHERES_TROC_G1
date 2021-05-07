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
    <div>
        <label for="nom_article" class="form-label">Article :</label>
        <input type="text" class="form-control" id="nom_article" required>
    </div>
    <div class="mb-3">
        <label for="description" class="form-label">Description :</label>
        <input type="text" class="form-control" id="description" required>
    </div>
    <div class="mb-3">
        <label for="categorie" class="form-label">Catégorie :</label>
        <input type="number" class="form-control" id="categorie" required>
    </div>
    <div class="mb-3">
        <label for="photo" class="form-label">Photo de l'article :</label>
        <input type="file" class="form-control" id="photo">
    </div>
    <div class="mb-3">
        <input type="number" class="form-label" id="prix_depart" min="0" required>
        <label class="form-label" for="prix_depart">Mise à prix</label>
    </div>
    <div class="mb-3">
        <input type="datetime-local" class="form-label" id="debut_encheres" required>
        <label class="form-label" for="debut_encheres">Début de la vente</label>
    </div>
    <div class="mb-3">
        <input type="datetime-local" class="form-label" id="fin_encheres" required>
        <label class="form-label" for="debut_encheres">Fin de la vente</label>
    </div>
    <%-- PARTIE RETRAIT --%>
    <div class="mb-3">
        <input type="text" class="form-label" id="rue" required>
        <label class="form-label" for="rue">Rue :</label>
    </div>
    <div class="mb-3">
        <input type="number" class="form-label" id="code_postal" min="0" max="99000" required>
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

</script>
</body>
</html>


