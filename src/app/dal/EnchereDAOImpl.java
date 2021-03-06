package app.dal;

import app.bo.Enchere;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EnchereDAOImpl extends MaConnexion implements DAOEncheres {

    private final String SELECT_BY_ID = "USE Encheres SELECT * FROM Encheres WHERE no_enchere=?";
    private final String SELECT_ALL = "USE Encheres SELECT * FROM Encheres";
    private final String SELECT_ALL_BY_ID_ARTICLE = "USE Encheres SELECT * FROM Encheres WHERE no_article=?";
    private final String UPDATE = "USE Encheres UPDATE Encheres SET date_enchere = ?, montant_enchere = ?," +
                                    " no_article = ?, no_utilisateur = ? WHERE no_enchere = ?";
    private final String INSERT = "USE Encheres INSERT INTO Encheres (date_enchere, montant_enchere, " +
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
            throw new DALException("Probl??me dans la s??lection d'une ench??re");
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
            throw new DALException("Probl??me dans la s??lection des ench??res");
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
            throw new DALException("Probl??me dans la mise ?? jour d'une ench??re");
        }
    }

    @Override
    public Enchere insert(Enchere enchere) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            var date =   enchere.getDate_enchere().getTime();
            stmt.setTimestamp(1,  new java.sql.Timestamp(date) );
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
            throw new DALException("Probl??me dans l'insertion d'une ench??re");
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
            throw new DALException("Probl??me dans la suppression d'une ench??re");

        }

    }

    @Override
    public List<Enchere> selectAllByIdArticle(int id) throws DALException {
        List<Enchere> listeEnchere = new ArrayList<Enchere>();
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL_BY_ID_ARTICLE);
            stmt.setInt(1, id);
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
            throw new DALException("Probl??me dans la s??lection des ench??res par id article");
        }
        return listeEnchere;
    }
}
