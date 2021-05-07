package app.dal;

import app.bo.Enchere;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EnchereDAOImpl extends MaConnexion implements DAO<Enchere> {

    private final String SELECT_BY_ID = "USE Encheres SELECT * FROM Encheres WHERE no_enchere=?";
    private final String SELECT_ALL = "USE Encheres SELECT * FROM Encheres";
    private final String UPDATE = "USE Encheres UPDATE Encheres SET date_enchere = ?, montant_enchere = ?," +
                                    " no_article = ?, no_utilisateur = ? WHERE no_enchere = ?";
    private final String INSERT = "INSERT INTO Encheres (date_enchere, montant_enchere, " +
                                    "no_article, no_utilisateur) VALUES (?, ?, ?, ?)";
    private final String DELETE = "USE Encheres DELETE FROM Encheres WHERE no_enchere = ?";

    @Override
    public Enchere selectById(int id) throws DALException {
        Enchere enchere = null;
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int no_enchere = rs.getInt("no_enchere");
                Date date_enchere = rs.getDate("date_enchere");
                int montant_enchere = rs.getInt("montant_enchere");
                int no_article = rs.getInt("no_article");
                int no_utilisateur = rs.getInt("no_utilisateur");
                enchere = new Enchere();
                enchere.setNo_enchere(no_enchere);
                enchere.setDate_enchere(date_enchere);
                enchere.setMontant_enchere(montant_enchere);
                enchere.setNo_article(no_article);
                enchere.setNo_utilisateur(no_utilisateur);
            }
            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection d'une enchère");
        }
        return enchere;
    }

    @Override
    public List<Enchere> selectAll() throws DALException {
        List<Enchere> listeEnchere = new ArrayList<Enchere>();
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int no_enchere = rs.getInt("no_enchere");
                Date date_enchere = rs.getDate("date_enchere");
                int montant_enchere = rs.getInt("montant_enchere");
                int no_article = rs.getInt("no_article");
                int no_utilisateur = rs.getInt("no_utilisateur");
                Enchere enchere = new Enchere();
                enchere.setNo_enchere(no_enchere);
                enchere.setDate_enchere(date_enchere);
                enchere.setMontant_enchere(montant_enchere);
                enchere.setNo_article(no_article);
                enchere.setNo_utilisateur(no_utilisateur);

                listeEnchere.add(enchere);

            }
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection des enchères");
        }
        return listeEnchere;
    }

    @Override
    public void update(Enchere enchere) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);
            stmt.setDate(1, (Date) enchere.getDate_enchere());
            stmt.setInt(2, enchere.getMontant_enchere());
            stmt.setInt(3, enchere.getNo_article());
            stmt.setInt(4, enchere.getNo_utilisateur());
            stmt.executeUpdate();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la mise à jour d'une enchère");
        }
    }

    @Override
    public Enchere insert(Enchere enchere) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmt.setDate(1, (Date) enchere.getDate_enchere());
            stmt.setInt(2, enchere.getMontant_enchere());
            stmt.setInt(3, enchere.getNo_article());
            stmt.setInt(4, enchere.getNo_utilisateur());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
           enchere.setNo_enchere(generatedKey);

            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans l'insertion d'une enchère");
        }
        return enchere;
    }






    @Override
    public void delete(int id) throws DALException {
        try {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(DELETE);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la suppression d'une enchère");

        }

    }

}
