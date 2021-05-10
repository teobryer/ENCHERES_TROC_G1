package app.service;


import app.bll.BusinessException;
import app.bll.ManagerFactory;
import app.bo.Articles_Vendus;
import app.bo.Utilisateurs;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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
