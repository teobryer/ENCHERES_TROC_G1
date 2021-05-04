package app.dal;

import app.bo.Utilisateurs;

public interface DAOConnect extends DAO<Utilisateurs> {

    Utilisateurs connectByPseudo(String pseudo, String password)throws DALException;
    Utilisateurs connectByEmail(String mail, String password)throws DALException;
}
