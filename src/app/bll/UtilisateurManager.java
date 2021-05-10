package app.bll;

import app.bo.Utilisateurs;
import app.dal.DALException;
import app.dal.DAOFact;

public class UtilisateurManager implements IUtilisateurManager{
    @Override
    public Utilisateurs seConnecter(String login, String password) throws BusinessException {
       Utilisateurs user;
        try {
          user = DAOFact.getUtilisateursDAO().connect(login, password);
        } catch (DALException e) {

                throw new BusinessException("Erreur de connexion","Aucune association de pseudo/mot de passe ou de email/mot de passe n'a été trouvée.");


        }
        return user;
    }

    @Override
    public void inscrireUtilisateur(Utilisateurs user) throws BusinessException {
        try {
            DAOFact.getUtilisateursDAO().insert(user);
        } catch (DALException e) {
            throw new BusinessException("Echec inscription", "Inscription de l'utilisateur impossible");
        }
    }

    @Override
    public void supprimerUtilisateur(int idUser) throws BusinessException {
        try {
            DAOFact.getUtilisateursDAO().delete(idUser);
        } catch (DALException e) {
            throw new BusinessException("Echec suppression", "Impossible de supprimer cet utilisateur");
        }
    }

    @Override
    public void modifierUtilisateur(Utilisateurs user, String ancien_mot_de_passe) throws BusinessException {
        try {
            //Récupération de l'utilisateur
            Utilisateurs oldUser = DAOFact.getUtilisateursDAO().selectById(user.getNo_utilisateur());
            if (!oldUser.getMot_de_passe().equals( ancien_mot_de_passe)){
                throw new BusinessException("Echec modification", "La saisie de l'ancien mot de passe n'est pas correct");
            }else{

                // Vérifier le nouveau et l'ancien mot de passe
                if (user.getPrenom() == null){
                    user.setPrenom(oldUser.getPrenom());
                }
                if (user.getNom() == null){
                    user.setNom(oldUser.getNom());
                }
                if (user.getPseudo() == null){
                    user.setPseudo(oldUser.getPseudo());
                }
                if (user.getEmail() == null){
                    user.setEmail(oldUser.getEmail());
                }
                if (user.getTelephone() == null){
                    user.setTelephone(oldUser.getTelephone());
                }
                if (user.getRue() == null){
                    user.setRue(oldUser.getRue());
                }
                if (user.getCode_postal() == null){
                    user.setCode_postal(oldUser.getCode_postal());
                }
                if (user.getVille() == null){
                    user.setVille(oldUser.getVille());
                }
                if (user.getMot_de_passe() == null){
                    user.setMot_de_passe(oldUser.getMot_de_passe());
                }
            }
            if (user.getCredit() < 0 ){
                user.setCredit(oldUser.getCredit());
            }

            user.setAdministrateur(oldUser.isAdministrateur());

            DAOFact.getUtilisateursDAO().update(user);
        }catch (DALException e) {
            throw new BusinessException("Echec modification", "Impossible de modifier le profil");
        }
    }

}
