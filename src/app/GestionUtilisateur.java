package app;

import app.bll.BusinessException;
import app.bll.ManagerFactory;
import app.bo.Utilisateurs;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/utilisateur")
public class GestionUtilisateur {

    @POST
    @Path("/connexion")
    public Response connexion(@FormParam("login") String login, @FormParam("password") String password) throws Exception {
        Response response;
        try {
            Utilisateurs user = ManagerFactory.utilisateurManager().seConnecter(login, password);
            response = Response.ok().entity(user).build();

        } catch (BusinessException e) {
            response = Response.status(401).entity(e).build();


            return response;
        }
        return response;
    }

    @POST
    @Path("/inscription")
    public Response inscrire(@FormParam("pseudo") String pseudo, @FormParam("prenom") String prenom, @FormParam("nom") String nom,
                             @FormParam("email") String email, @FormParam("telephone") String telephone,
                             @FormParam("code_postal") String code_postal, @FormParam("ville") String ville,
                             @FormParam("rue") String rue, @FormParam("mot_de_passe") String mot_de_passe) throws Exception {
        Response response;
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
            response = Response.ok().build();
        } catch (BusinessException e) {
            response = Response.status(401).entity(e).build();
        }
        return response;
    }

    @DELETE
    @Path("suppression/{id: \\d+}")
    public Response supprimerUtilisateur(@PathParam("id") int idUser) throws Exception {
        Response response;
        try {
            ManagerFactory.utilisateurManager().supprimerUtilisateur(idUser);
            response = Response.ok().build();
        } catch (BusinessException e) {
            response = Response.status(401).entity(e).build();
            return response;
        }
        return response;
    }

    /**
     * Modification d'un profil utilisateur
     *
     * @param no_utilisateur
     * @param pseudo
     * @param prenom
     * @param nom
     * @param email
     * @param telephone
     * @param code_postal
     * @param ville
     * @param rue
     * @param ancien_mot_de_passe
     * @param nouveau_mot_de_passe
     * @return Response
     */
    @PUT
    @Path("/modification/{id: \\d+}")
    public Response modification(@PathParam("id") int no_utilisateur, @FormParam("pseudo") String pseudo, @FormParam("prenom") String prenom, @FormParam("nom") String nom,
                                 @FormParam("email") String email, @FormParam("telephone") String telephone,
                                 @FormParam("code_postal") String code_postal, @FormParam("ville") String ville,
                                 @FormParam("rue") String rue, @FormParam("ancien_mot_de_passe") String ancien_mot_de_passe, @FormParam("nouveau_mot_de_passe") String nouveau_mot_de_passe) {

        Utilisateurs utilisateur = new Utilisateurs();
        utilisateur.setNo_utilisateur(no_utilisateur);
        utilisateur.setPseudo(pseudo);
        utilisateur.setPrenom(prenom);
        utilisateur.setNom(nom);
        utilisateur.setEmail(email);
        utilisateur.setTelephone(telephone);
        utilisateur.setRue(rue);
        utilisateur.setCode_postal(code_postal);
        utilisateur.setVille(ville);
        utilisateur.setCredit(100);
        utilisateur.setAdministrateur(false);
        Response response;

        try {
            ManagerFactory.utilisateurManager().modifierUtilisateur(utilisateur, nouveau_mot_de_passe);
            response = Response.ok().build();
        } catch (BusinessException e) {
            response = Response.status(304).entity(e).build();
            return response;
        }
        return response;
    }
}
