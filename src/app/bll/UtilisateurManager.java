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
}
