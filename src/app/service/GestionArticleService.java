package app.service;


import app.bll.BusinessException;
import app.bll.ManagerFactory;
import app.bo.Articles_Vendus;
import app.bo.Retraits;
import app.bo.Utilisateurs;
import app.dal.DAOFact;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/articles")
public class GestionArticleService {


    @GET
    public Response getArticles() throws Exception {
        Response response;

        try {
          List<Articles_Vendus> articles =ManagerFactory.articlesVendusManager().recupererLesArticles();
            response= Response.ok().entity(articles).build();
        }catch (BusinessException e) {
            response=Response.status(404).entity(e).build();
        }
        return response;


    }

    @POST
    @Path("/vendreArticle")
    public Response vendreArticle(@FormParam("nom_article") String nom_article,
                                  @FormParam("description") String description,
//                                  @FormParam("date_debut_encheres") Date date_debut_encheres,
//                                  @FormParam("date_fin_encheres") Date date_fin_encheres,
                                  @FormParam("prix_initial") int prix_initial,
                                  @FormParam("no_utilisateur") int no_utilisateur, @FormParam("no_categorie") int no_categorie,
                                  @FormParam("rue") String rue, @FormParam("code_postal") String code_postal,
                                  @FormParam("ville") String ville) throws Exception {
        Response response = null;
        // SET ADRESSE
        Articles_Vendus article = new Articles_Vendus();
        article.setNom_article(nom_article);
        article.setDescription(description);
//        article.setDate_debut_encheres(date_debut_encheres);
//        article.setDate_fin_encheres(date_fin_encheres);
        article.setPrix_initial(prix_initial);
        article.setUtilisateur(DAOFact.getUtilisateursDAO().selectById(no_utilisateur));
        article.setCategorie(DAOFact.getCategoriesDAO().selectById(no_categorie));
        // SET RETRAIT
        Retraits adresseDeRetrait = new Retraits();
        // TODO Gérer le numéro article de adresseDeRetrait
        adresseDeRetrait.setRue(rue);
        adresseDeRetrait.setCode_postal(code_postal);
        adresseDeRetrait.setVille(ville);

        try {
            ManagerFactory.articlesVendusManager().vendreUnArticle(article, adresseDeRetrait);
        } catch (BusinessException e) {
            response = Response.status(401).entity(e).build();
        }
        return response;
    }

    @GET
    @Path("/{id: \\d+}")
    public Response recupererArticle(@PathParam("id") int idArticle) throws Exception {
        Response response;
        try {
          Articles_Vendus a =   ManagerFactory.articlesVendusManager().recupererArticleParId(idArticle);
            response = Response.ok().entity(a).build();
        } catch (BusinessException e) {
            response=Response.status(404).entity(e).build();
            return  response;
        }
        return  response;
    }
}
