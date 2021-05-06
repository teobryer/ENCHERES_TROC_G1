package app.dal;


import app.bo.Enchere;


public class DAOFact {

 	public static DAOConnect getUtilisateursDAO(){ return new UtilisateurDAOImpl();}
    public static DAO<Enchere> getEncheresDAO() {
		return new EnchereDAOImpl();
    }
}
