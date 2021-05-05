package app;

import app.bll.BusinessException;
import app.bll.NoteManagerSingleton;
import app.bll.UtilisateurManagerSingleton;
import app.bo.Utilisateurs;

import javax.servlet.ServletException;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/utilisateur")
public class GestionUtilisateur {

    @POST
    @Path("/connexion")
    public Utilisateurs connexion(@FormParam("login") String login, @FormParam("password") String password) throws Exception {
        try {
            return UtilisateurManagerSingleton.getInstance().seConnecter(login, password);
        } catch (BusinessException e) {
            throw new ServletException("Connexion servlet");
        }
    }

    @POST
    @Path("/inscrire")
    public void inscrire(@FormParam("noteTexte") String noteTexte) throws Exception {

    }
}
