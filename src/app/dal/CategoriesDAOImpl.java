package app.dal;

import app.bo.Articles_Vendus;
import app.bo.Categories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoriesDAOImpl extends MaConnexion implements DAO<Categories> {

    private final String SELECT_BY_ID = "SELECT * FROM Categories WHERE no_categorie = ?";
    private final String SELECT_ALL = "SELECT * FROM Categories";

    @Override
    public Categories selectById(int id) throws DALException {
        Categories categorie = null;
        try {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int no_categorie = rs.getInt("no_categorie");
                String libelle = rs.getString("libelle");
                categorie = new Categories();
                categorie.setNo_categorie(no_categorie);
                categorie.setLibelle(libelle);
            }
            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection d'une catégorie");
        }
        return categorie;
    }

    @Override
    public List<Categories> selectAll() throws DALException {
        List<Categories> listCategories = new ArrayList<Categories>();
        try {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int no_categorie = rs.getInt("no_categorie");
                String libelle = rs.getString("libelle");
                Categories categorie = new Categories();
                categorie.setNo_categorie(no_categorie);
                categorie.setLibelle(libelle);

                listCategories.add(categorie);

            }
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection des catégories");
        }
        return listCategories;
    }

    @Override
    public void update(Categories categories) throws DALException {

    }

    @Override
    public Categories insert(Categories categories) throws DALException {
        return null;
    }

    @Override
    public void delete(int id) throws DALException {

    }
}
