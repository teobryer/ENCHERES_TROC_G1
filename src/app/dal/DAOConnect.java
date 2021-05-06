package app.dal;

import app.bo.Utilisateurs;

public interface DAOConnect extends DAO<Utilisateurs> {


    Utilisateurs connect(String mail, String password)throws DALException;
}
