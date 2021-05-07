package app.dal;


import app.bo.Articles_Vendus;
import app.bo.Enchere;
import app.bo.Retraits;


public class DAOFact {

 	public static DAOConnect getUtilisateursDAO(){ return new UtilisateurDAOImpl();}
    public static DAO<Enchere> getEncheresDAO() {
		return new EnchereDAOImpl();
    }
    public static DAO<Articles_Vendus> getArticlesDAO() {
 	    return new Articles_VendusDAOImpl();
 	}
 	public static DAO<Retraits> getRetraitsDAO() {
 		return new RetraitsDAOImpl();
	}
}
