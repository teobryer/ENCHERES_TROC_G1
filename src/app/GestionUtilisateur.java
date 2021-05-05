package app;

import app.bll.BusinessException;
import app.bll.NoteManagerSingleton;
import app.bll.UtilisateurManagerSingleton;
import app.bo.Utilisateurs;

import javax.servlet.ServletException;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/utilisateur")
public class GestionUtilisateur {

    @POST
    @Path("/connexion")
//    public Utilisateurs connexion(@FormParam("login") String login, @FormParam("password") String password) throws Exception {
//        try {
//            return UtilisateurManagerSingleton.getInstance().seConnecter(login, password);
//        } catch (BusinessException e) {
//            throw new ServletException("Connexion servlet");
//        }
//    }

    public Response connexion(@FormParam("login") String login, @FormParam("password") String password) throws Exception {
        Response response;
        try {
            Utilisateurs user =  UtilisateurManagerSingleton.getInstance().seConnecter(login, password);
            response= Response.ok().entity(user).build();

        } catch (BusinessException e) {
            response=Response.status(401).entity(e).build();



            return  response;
        }
        return  response;
    }

    @POST
    @Path("/inscrire")
    public void inscrire(@FormParam("noteTexte") String noteTexte) throws Exception {

    }
}
