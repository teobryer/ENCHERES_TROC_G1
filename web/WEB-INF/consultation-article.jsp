<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Téo
  Date: 10/05/2021
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/css/style_article.css" />">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="error_fragment.jsp"></jsp:include>
<jsp:include page="bootstrap_fragment.jsp"></jsp:include>


<div class="container">
    <div class="card">
        <div class="container-fliud">
            <div class="wrapper row">
                <div class="preview col-md-6">

                    <div class="preview-pic tab-content">
                        <div class="tab-pane active" id="pic-1"><img src="http://placekitten.com/400/252" /></div>
                        <div class="tab-pane" id="pic-2"><img src="http://placekitten.com/400/252" /></div>
                        <div class="tab-pane" id="pic-3"><img src="http://placekitten.com/400/252" /></div>
                        <div class="tab-pane" id="pic-4"><img src="http://placekitten.com/400/252" /></div>
                        <div class="tab-pane" id="pic-5"><img src="http://placekitten.com/400/252" /></div>
                    </div>
                    <ul class="preview-thumbnail nav nav-tabs">
                        <li class="active"><a data-target="#pic-1" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
                        <li><a data-target="#pic-2" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
                        <li><a data-target="#pic-3" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
                        <li><a data-target="#pic-4" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
                        <li><a data-target="#pic-5" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
                    </ul>

                </div>
                <div class="details col-md-6">
                    <h3 id="nom_article" class="product-title">Pc gamer pour travailler</h3>
<%--                    <div class="rating">--%>
<%--                        <div class="stars">--%>
<%--                            <span class="fa fa-star checked"></span>--%>
<%--                            <span class="fa fa-star checked"></span>--%>
<%--                            <span class="fa fa-star checked"></span>--%>
<%--                            <span class="fa fa-star"></span>--%>
<%--                            <span class="fa fa-star"></span>--%>
<%--                        </div>--%>
<%--                        <span class="review-no">41 reviews</span>--%>
<%--                    </div>--%>
                    <p id="description" class="product-description">Ensemble neuf sous facture (plus de 2500 €)

                        PC fixe gamer composé de :

                        - Clavier Logitech MX Keys
                        - souris Logitech MX Anywhere 3
                        - Ecran Dell Alienware AW2521HFL Écran de Gaming Full HD 1920 x 1080 à 240 Hz, IPS antireflet, 16:9, Compatible AMD FreeSync Premium & G-Sync, 1 ms, Hauteur réglable
                        - 4 ventilateurs 120 mm BeQuiet BL066
                        - Crucial Ballistix BL2K16G32C16U4W 3200 MHz, DDR4, DRAM, Mémoire Kit pour PC de Gamer, 32Go (16Go x2)
                        - Carte mère Gigabyte Z590I Vision D (Socket 1200/Z590 Express/DDR4/S-ATA 600/Mini-ITX)
                        </p>
                    <h5 class="price">Meilleure offre : <span id="meilleure_offre">180 points</span></h5>
                    <h5 class="price">Mise à prix : <span id="mise_a_prix">150 points</span></h5>
                    <h5 class="price">Fin de l'enchère : <span id="fin_encheres">12/05/2021</span></h5>
                    <h5 class="price">Retrait : <span id="retrait">10 allée des Alouettes, SAINT HERBLAIN 44800</span></h5>
                    <h5 class="price">Vendeur : <span id="vendeur">jojo44</span></h5>
                    <h5 class="price">Proposition : <span>  <input type="number" class="form-label" id="proposition" min="0" required></span></h5>

<%--                    <h5 class="sizes">sizes:--%>
<%--                        <span class="size" data-toggle="tooltip" title="small">s</span>--%>
<%--                        <span class="size" data-toggle="tooltip" title="medium">m</span>--%>
<%--                        <span class="size" data-toggle="tooltip" title="large">l</span>--%>
<%--                        <span class="size" data-toggle="tooltip" title="xtra large">xl</span>--%>
<%--                    </h5>--%>

                    <div class="action">
                        <button class="add-to-cart btn btn-default" type="button">Enchérir</button>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%--<h1>${requestScope.id}</h1>--%>

<%--<div class="row">--%>

<%--    <div class="col align-self-center" style="text-align: center">Détail vente</div>--%>
<%--</div >--%>

<%--<div class="container d-flex flex-column justify-content-between align-items-center">--%>
<%--    <ul style="list-style: none">--%>
<%--        <li style="flex-wrap: wrap" class="my-1"><div style="display: flex" >Description : zzzzzzzzzzzzz zzzzzzzz zzzzz zzzz zzzz zz  zzzzz  zzzz</div> </li>--%>
<%--        <li class="my-1">Catégorie :        rrjrjrj</li>--%>
<%--        <li class="my-1">Meilleure offre :  230  </li>--%>
<%--        <li class="my-1">Mise à prix :      120 </li>--%>
<%--        <li class="my-1">Fin de l'enchère : 12/05/2025</li>--%>
<%--        <li class="my-1">Retrait :          10 rue des alouettes, SAINT HERBLAIN </li>--%>
<%--        <li class="my-1">Vendeur :          jojjo44 </li>--%>
<%--        <li class="my-1">Ma proposition <input/></li>--%>
<%--    </ul>--%>
<%--    <a href="profil" class="btn btn-success">Enchérir</a>--%>
<%--</div>--%>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

<script>
    function recupererArticle(id){
        $.ajax({
            type:"GET",
            url: "http://localhost:8080/troc_encheres_groupe_1/api/articles/"+${requestScope.id},
            success: function(article){
                console.log(article);

                    ajouterArticle(article["nom_article"],article["description"],article["date_debut_encheres"],article["date_fin_encheres"],article["prix_initial"],article["prix_vente"],article["utilisateur"]["pseudo"],article["no_categorie"]);


                notifier("Succès","Récupération des données");

            },
            error: function (data) {
                console.log("data", data);

                notifier(data.responseJSON.title,data.responseJSON.message)
            }
        });
    }


    function afficherArticle(article){
        $("#meilleure_offre").text = article["prix_vente"];
        $("#nom_article").text = article["nom_article"];
        $("#description").text = article["description"];
        $("#mise_a_prix").text = article["mise_a_prix"];
        $("#fin_encheres").text = article["date_fin_encheres"];
        $("#retrait").text = article["prix_vente"];
        $("#vendeur").text = article["utilisateur"]["pseudo"];



    }
</script>
