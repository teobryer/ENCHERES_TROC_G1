package app.dal;


import app.bo.Enchere;
import app.bo.Note;


public class DAOFact {
	public static DAO<Note> getNotesDAO() {
		return new NoteDAOImpl();
	}

 	public static DAOConnect getUtilisateursDAO(){ return new UtilisateurDAOImpl();}
    public static DAO<Enchere> getEncheresDAO() {
		return new EnchereDAOImpl();
    }
}
