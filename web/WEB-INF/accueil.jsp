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
    <title>Page d'accueil</title>
    <link rel="icon" href="favicon.ico" />
    <jsp:include page="bootstrap_fragment.jsp"></jsp:include>

</head>
<body>
<jsp:include page="error_fragment.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>






<div class= "container-fluid">
    <h4>Articles en ventes</h4>
    <div id="gallery" style="width: 92vw" class= "row d-inline-flex ml-5 mr-5">

<%--        <div class="col-12 col-sm-5 col-md-4 col-lg-3 col-xl-2 col-xxl-2">--%>
<%--        <div class="card  p-2 m-1">--%>
<%--            <img class="card-img-top" src="..." alt="Card image cap">--%>
<%--            <div class="card-body">--%>
<%--                <h5 class="card-title">Card title</h5>--%>
<%--                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>--%>
<%--                <a href="#" class="btn btn-primary">Go somewhere</a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        </div>--%>


    </div>

</div>




<script>
    function ajouterArticle(nom, description, debut, fin, prixInit, prixFin, nomUser, nomCategorie){



        let html = '<div class="col-10 col-sm-5 col-md-4 col-lg-3 col-xl-2 col-xxl-2">'+
            ' <div class="card  p-2 m-1">'+

            ' <div class="card-body">'+
            ' <h5 id="nom" class="card-title">'+nom+'</h5>'+
            ' <p id="description" class="card-text">'+description+'</p>'+


                '<div>Prix initial : '+prixInit+'€</div>'+

               ' <div>Prix actuel : '+prixFin+'€</div>'+

            ' <a id="lien" href="#" class="btn btn-primary">'+'Enchérir'+'</a>'+
            '</div>'+
            '</div>'
        '</div>';
        console.log(html);
        $('#gallery').append(html);
    }

    function afficherArticles() {
        //$("#notes").remove();


        $.ajax({
            type:"GET",
            url: "http://localhost:8080/troc_encheres_groupe_1/api/articles",
            success: function(data){
                console.log(data);
                $.each(data, (cpt, article) => {
                    console.log(article);
                    ajouterArticle(article["nom_article"],article["description"],article["date_debut_encheres"],article["date_fin_encheres"],article["prix_initial"],article["prix_vente"],article["utilisateur"]["pseudo"],article["no_categorie"]);

                });
                notifier("Succès","Récupération des données");

            },
            error: function (data) {
                console.log("data", data);

                notifier(data.responseJSON.title,data.responseJSON.message)
            }
        });
    }


afficherArticles();

</script>



<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>

}



