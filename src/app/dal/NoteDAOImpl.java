package app.dal;

import app.bo.Note;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class NoteDAOImpl implements DAO<Note> {

    private final String SELECT_BY_ID = "USE NotesBDD SELECT * FROM Notes WHERE idNote=?";
    private final String SELECT_ALL = "USE NotesBDD SELECT * FROM Notes";
    private final String UPDATE = "USE NotesBDD UPDATE Notes SET texteNote = ?  WHERE idNote= ?";
    private final String INSERT = "USE NotesBDD INSERT INTO Notes (texteNote) VALUES (?)";
    private final String DELETE = "USE NotesBDD DELETE FROM Notes WHERE idNote= ?";


    private Connection connect() {
        try {
            // Je vais chercher le fichier context.xml
            Context context = new InitialContext();
            // Je vais lire le fichier context.xml
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            // J'ouvre une connection
            Connection cnx = ds.getConnection();
            return cnx;
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Note selectById(int id) throws DALException {
        Note note = null;
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idNote = rs.getInt("idNote");
                String texteNote = rs.getString("texteNote");
                note = new Note();
                note.setId(idNote);
                note.setTexteNote(texteNote);

            }
            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection d'une note");
        }
        return note;
    }

    @Override
    public List<Note> selectAll() throws DALException {
        List<Note> listeNote = new ArrayList<Note>();
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // TODO : ajouter la gestion de l'idCar dans la BO et le récupérer ici
                // gitignore
                int idNote = rs.getInt("idNote");
                String texteNote = rs.getString("texteNote");
                Note note = new Note();
                note.setId(idNote);
                note.setTexteNote(texteNote);
                listeNote.add(note);

            }
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection des notes");
        }
        return listeNote;
    }

    @Override
    public void update(Note note) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);
            stmt.setString(1, note.getTexteNote());
            stmt.setInt(2, note.getId());
            stmt.executeUpdate();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la mise à jour d'une note");
        }
    }

    @Override
    public Note insert(Note note) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, note.getTexteNote());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
           note.setId(generatedKey);

            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans l'insertion d'une note");
        }
        return note;
    }






    @Override
    public void delete(int id) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(DELETE);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la suppression d'une note");

        }

    }

}
