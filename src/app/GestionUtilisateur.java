package app;

import app.bll.BusinessException;
import app.bll.ManagerFactory;
import app.bo.Utilisateurs;

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
            Utilisateurs user =  ManagerFactory.utilisateurManager().seConnecter(login, password);
            response= Response.ok().entity(user).build();

        } catch (BusinessException e) {
            response=Response.status(401).entity(e).build();



            return  response;
        }
        return  response;
    }

    @POST
    @Path("/inscription")
    public Response inscrire(@FormParam("pseudo") String pseudo, @FormParam("prenom") String prenom, @FormParam("nom") String nom,
                         @FormParam("email") String email, @FormParam("telephone") String telephone,
                         @FormParam("code_postal") String code_postal, @FormParam("ville") String ville,
                         @FormParam("rue") String rue, @FormParam("mot_de_passe") String mot_de_passe) throws Exception {
        Response response = null;
        Utilisateurs utilisateur = new Utilisateurs();
        utilisateur.setPseudo(pseudo);
        utilisateur.setPrenom(prenom);
        utilisateur.setNom(nom);
        utilisateur.setEmail(email);
        utilisateur.setTelephone(telephone);
        utilisateur.setRue(rue);
        utilisateur.setCode_postal(code_postal);
        utilisateur.setVille(ville);
        utilisateur.setMot_de_passe(mot_de_passe);
        utilisateur.setCredit(100);
        utilisateur.setAdministrateur(false);

        try {
            ManagerFactory.utilisateurManager().inscrireUtilisateur(utilisateur);
            response= Response.ok().build();
        }catch (BusinessException e) {
            response=Response.status(401).entity(e).build();
        }
        return response;
    }
}
