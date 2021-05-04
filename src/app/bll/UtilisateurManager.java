package app.bll;

import app.bo.Utilisateurs;
import app.dal.DALException;
import app.dal.DAOFact;

public class UtilisateurManager implements IUtilisateurManager{
    @Override
    public Utilisateurs seConnecter(String login, String password) throws BusinessException {
       Utilisateurs user;
        try {
          user =  DAOFact.getUtilisateursDAO().connectByEmail(login, password);
        } catch (DALException e) {
            try {
            user =  DAOFact.getUtilisateursDAO().connectByPseudo(login, password);
            } catch (DALException dalException) {
                throw new BusinessException("BLL Se connecter");
            }

        }
        return  user;
    }

    @Override
    public void inscrireUtilisateur(Utilisateurs user) throws BusinessException {
        try {
            DAOFact.getUtilisateursDAO().insert(user);
        } catch (DALException e) {
            throw new BusinessException("BLL S'inscrire");
        }
    }
}
