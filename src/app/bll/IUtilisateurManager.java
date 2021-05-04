package app.bll;

import app.bo.Utilisateurs;
import app.dal.DALException;

public interface IUtilisateurManager {

    Utilisateurs seConnecter(String login, String password) throws BusinessException, DALException;

    void inscrireUtilisateur(Utilisateurs user)throws BusinessException;
}
