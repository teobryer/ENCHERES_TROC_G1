package app.dal;


import app.bo.Note;


public class DAOFact {
	public static DAO<Note> getNotesDAO() {
		return new NoteDAOImpl();
	}
	
	

	

}
