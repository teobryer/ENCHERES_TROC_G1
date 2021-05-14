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
    <jsp:include page="bootstrap_fragment.jsp"></jsp:include>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>



<div class="container">
    <div class="card">
        <div class="container-fliud">
            <div class="wrapper row">
                <div class="preview col-md-6">

                    <div class="preview-pic tab-content">
                        <div class="tab-pane imgart text-center active" id="pic-1"><img width="auto" height="252"  src="https://www.marentreepaschere.com/1181-large_default/stylo-bille-bic-cristal-pointe-moyenne-avec-capuchon-bleu.jpg"/></div>
                        <div class="tab-pane imgart text-center" id="pic-2"><img width="auto" height="252"  src="https://www.fiducial-office-solutions.fr/INTERSHOP/static/WFS/FOS-FR-Site/-/FOS/fr_FR/L/17245106/172451.06.jpg" /></div>
                        <div class="tab-pane imgart text-center" id="pic-3"><img width="auto" height="252"   src="https://bv-prd-fbi-fr-media.s3.amazonaws.com/pub/media/catalog/product/cache/ef4a54899b4f9d060853d6e60ec5e0f4/9/d/9d7bc4f7d4421e0b790fe746e4504877786329f9_2502_1.jpg" /></div>

                    </div>
                    <ul class="preview-thumbnail nav nav-tabs">
                        <li class="active"><a data-target="#pic-1" data-toggle="tab"><img width="auto" height="126" src="https://www.marentreepaschere.com/1181-large_default/stylo-bille-bic-cristal-pointe-moyenne-avec-capuchon-bleu.jpg" /></a></li>
                        <li><a data-target="#pic-2" data-toggle="tab"><img width="auto" height="126" src="https://www.fiducial-office-solutions.fr/INTERSHOP/static/WFS/FOS-FR-Site/-/FOS/fr_FR/L/17245106/172451.06.jpg" /></a></li>
                        <li><a data-target="#pic-3" data-toggle="tab"><img width="auto" height="126"  src="https://bv-prd-fbi-fr-media.s3.amazonaws.com/pub/media/catalog/product/cache/ef4a54899b4f9d060853d6e60ec5e0f4/9/d/9d7bc4f7d4421e0b790fe746e4504877786329f9_2502_1.jpg" /></a></li>

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
                    <h5 class="price">Fin de l'enchère : <span id="fin_encheres"><div id="compte_a_rebours"><noscript>Fin de l'évènement le 1er janvier 2018.</noscript></div></span></h5>
                    <h5 class="price">Retrait : <span id="retrait">10 allée des Alouettes, SAINT HERBLAIN 44800</span></h5>
                    <h5 class="price">Vendeur : <span id="vendeur">jojo44</span></h5>

                    <c:if test="${sessionScope.connectedUser != null}">
                        <h5 id="prop" class="price">Proposition : <span>  <input type="number" class="form-label" id="proposition" min="0" required></span></h5>
                        <div class="action">
                            <button id="encherir" onclick="encherir()" class="add-to-cart btn btn-default" type="button">Enchérir</button>

                        </div>
                    </c:if>

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
<script>
var dateEvent;
var articleCourrant = null;
    function afficherArticle(article){
        console.log(article);

        try{
            $("#meilleure_offre").text(article["enchereMax"]["montant_enchere"]+ ' points');
            $("#proposition").prop('min',parseInt(article["enchereMax"]["montant_enchere"])+1);
        }
        catch (e) {
            $("#meilleure_offre").text("Aucune offre actuellement");
            $("#proposition").prop('min',parseInt(article["prix_initial"]+1));
        }

        $("#nom_article").text(article["nom_article"]);
        $("#description").text ( article["description"]);
        $("#mise_a_prix").text( article["prix_initial"] + ' points');
    //    $("#fin_encheres").text(article["date_fin_encheres"]);
        $("#retrait").text(article["retrait"]["rue"]+", "+ article["retrait"]["code_postal"]+", "+ article["retrait"]["ville"]);
        $("#vendeur").text( article["utilisateur"]["pseudo"]);

var year = articleCourrant["date_fin_encheres"]["year"];
var month = articleCourrant["date_fin_encheres"]["monthValue"] - 1 ;
var day = articleCourrant["date_fin_encheres"]["dayOfMonth"];
console.log("Date du jour " + day +' '+ month + " "  +day );
dateEvent =  new Date(year,month,day );
        compte_a_rebours();

    }
    function recupererArticle(){
        $.ajax({
            type:"GET",
            url: "http://localhost:8080/troc_encheres_groupe_1/api/articles/"+${requestScope.id},
            success: function(article){
                console.log(article);
                articleCourrant = article;
              //  notifier("Succès","Récupération des données");
                afficherArticle(article);
                compte_a_rebours();



            },
            error: function (data) {
                console.log("data", data);

                notifier2(data.responseJSON.title,data.responseJSON.message,0)

            }
        });
    }


function compte_a_rebours()
{
    var compte_a_rebours = document.getElementById("compte_a_rebours");

    var date_actuelle = new Date();
    var date_evenement = dateEvent;
    var total_secondes = (date_evenement - date_actuelle) / 1000;

    var prefixe = "Se termine dans ";
    $("#encherir").css("display","visible");
    $("#prop").css("display","visible");
    if (total_secondes < 0)
    {
        $("#encherir").css("display","none");
        $("#prop").css("display","none");
        prefixe = "Terminé il y a "; // On modifie le préfixe si la différence est négatif
        total_secondes = Math.abs(total_secondes); // On ne garde que la valeur absolue
    }

    if (total_secondes > 0)
    {
        var jours = Math.floor(total_secondes / (60 * 60 * 24));
        var heures = Math.floor((total_secondes - (jours * 60 * 60 * 24)) / (60 * 60));
        minutes = Math.floor((total_secondes - ((jours * 60 * 60 * 24 + heures * 60 * 60))) / 60);
        secondes = Math.floor(total_secondes - ((jours * 60 * 60 * 24 + heures * 60 * 60 + minutes * 60)));

        var et = "";
        var mot_jour = "jours";
        var mot_heure = "h";
        var mot_minute = "mns";
        var mot_seconde = "s";

        if (jours == 0)
        {
            jours = '';
            mot_jour = '';
        }
        else if (jours == 1)
        {
            mot_jour = "jour";
        }

        if (heures == 0)
        {
            heures = '';
            mot_heure = '';
        }
        else if (heures == 1)
        {
            mot_heure = "h,";
        }

        if (minutes == 0)
        {
            minutes = '';
            mot_minute = '';
        }
        else if (minutes == 1)
        {
            mot_minute = "mn";
        }

        if (secondes == 0)
        {
            secondes = '';
            mot_seconde = '';
            et = '';
        }
        else if (secondes == 1)
        {
            mot_seconde = "s";
        }

        if (minutes == 0 && heures == 0 && jours == 0)
        {
            et = "";
        }

        compte_a_rebours.innerHTML = prefixe + jours + ' ' + mot_jour + ' ' + heures + ' ' + mot_heure + ' ' + minutes + ' ' + mot_minute + ' ' + et + ' ' + secondes + ' ' + mot_seconde;
    }
    else
    {
        compte_a_rebours.innerHTML = 'Compte à rebours terminé.';
    }

    var actualisation = setTimeout("compte_a_rebours();", 1000);
}

    recupererArticle();

    function encherir(){
        var proposition =  $("#proposition").val();

    }
let temps, secondesAuto = 0;
function resetTemps()
{
console.log("reset-temps");
    clearInterval(temps);
    secondesAuto = 0;
    temps = setInterval(startTemps, 1000);
}

window.onload = resetTemps;
window.ontouchstart = resetTemps;
window.onclick = resetTemps;
window.onkeypress = resetTemps;
window.onmousemove = resetTemps;
window.onmousedown = resetTemps;

function startTemps()
{
    secondesAuto++;

}

function updateArticle(){
    setInterval(recupererArticleSiActif, 3000);
}

function recupererArticleSiActif(){
console.log("recupererArticleSiActif | secondes : "+ secondesAuto)
    if(secondesAuto< 10){
        console.log("recuperation de l'article");
   recupererArticle();
    }

}
updateArticle();

function encherir(){

    let proposition = $("#proposition").val();
    let idArticle = articleCourrant["no_article"];
    console.log(articleCourrant);
    console.log(articleCourrant["no_article"]);
    let userID = "${sessionScope.connectedUser.no_utilisateur}";
    $.ajax({
        type:"POST",
        data: {idArticle: idArticle, idUser: userID , proposition: proposition},
        url: "http://localhost:8080/troc_encheres_groupe_1/api/articles/encherir",
        success: function(data){

            notifier2("Succès","Enchère envoyée",1);
            recupererArticle();




        },
        error: function (data) {
            console.log("data", data);

            notifier2(data.responseJSON.title,data.responseJSON.message,0)
        }
    });

}

</script>





<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="error_fragment.jsp"></jsp:include>
</body>
</html>


