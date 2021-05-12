package app.dal;

import app.bo.Retraits;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetraitsDAOImpl extends MaConnexion implements DAO<Retraits> {
    private final String SELECT_ALL = "USE ENCHERES SELECT * FROM Retraits";
    private final String SELECT_BY_ID = "USE ENCHERES SELECT * FROM Retraits WHERE no_article=?";
    //TODO: à finir
    private final String UPDATE = "USE ENCHERES UPDATE Retraits SET rue = ?, code_postal = ?, ville = ? WHERE no_article= ?";
    private final String INSERT = "USE ENCHERES INSERT INTO Retraits (no_article, rue, code_postal, ville) VALUES (?,?,?,?)";
    private final String DELETE = "USE ENCHERES DELETE FROM Retraits WHERE no_article= ?";

    @Override
    public Retraits selectById(int id) throws DALException{
        Retraits retraits = null;

        try{
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int no_article = rs.getInt("no_article");
                String rue = rs.getString("rue");
                String code_postal = rs.getString("code_postal");
                String ville = rs.getString("ville");

                retraits = new Retraits();

                retraits.setNo_article(no_article);
                retraits.setRue(rue);
                retraits.setCode_postal(code_postal);
                retraits.setVille(ville);
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection d'un retrait d'article");
        }

        return retraits;
    }

    @Override
    public List<Retraits> selectAll() throws DALException {
        List<Retraits> listeRetraits = new ArrayList<Retraits>();

        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // gitignore
                int no_article = rs.getInt("no_article");
                String rue = rs.getString("rue");
                String code_postal = rs.getString("code_postal");
                String ville = rs.getString("ville");
                Retraits retraits = new Retraits();


                retraits.setNo_article(no_article);
                retraits.setRue(rue);
                retraits.setCode_postal(code_postal);
                retraits.setVille(ville);
                listeRetraits.add(retraits);

            }
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection des retraits");
        }
        return listeRetraits;
    }

    @Override
    public void update(Retraits retraits) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);
            stmt.setString(1, retraits.getRue());
            stmt.setString(2, retraits.getCode_postal());
            stmt.setString(3, retraits.getVille());
            stmt.setInt(4, retraits.getNo_article());
            stmt.executeUpdate();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la mise à jour d'un retraits");
        }
    }

    @Override
    public Retraits insert(Retraits retraits) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, retraits.getNo_article());
            stmt.setString(2, retraits.getRue());
            stmt.setString(3, retraits.getCode_postal());
            stmt.setString(4, retraits.getVille());
            stmt.executeUpdate();

            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans l'insertion d'un retrait");
        }
        return retraits;
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
            throw new DALException("Problème dans la suppression d'un retrait");
        }
    }
}
