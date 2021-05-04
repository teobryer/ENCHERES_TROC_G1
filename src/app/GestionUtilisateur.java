package app;

import app.bll.BusinessException;
import app.bll.NoteManagerSingleton;
import app.bo.Utilisateurs;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/utilisateur")
public class GestionUtilisateur {

    @POST
    @Path("/connect")
    public Utilisateurs connexion(@FormParam("login") String login, @FormParam("password") String password) throws Exception {
     return null;
    }

    @POST
    @Path("/inscrire")
    public void inscrire(@FormParam("noteTexte") String noteTexte) throws Exception {

    }
}
