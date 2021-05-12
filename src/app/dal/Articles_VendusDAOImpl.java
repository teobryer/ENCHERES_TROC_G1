package app.dal;

import app.bo.Articles_Vendus;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Articles_VendusDAOImpl extends MaConnexion implements DAO<Articles_Vendus> {

    private final String SELECT_BY_ID = "USE Encheres SELECT * FROM Articles_Vendus WHERE no_article=?";
    private final String SELECT_ALL = " USE Encheres SELECT * FROM Articles_Vendus";
    private final String UPDATE = "USE Encheres UPDATE Articles_Vendus SET nom_article = ?, description = ?," +
                                    " date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?" +
                                    ", prix_vente = ?, no_utilisateur = ?, no_categorie = ? WHERE no_article = ?";
    private final String INSERT = "USE Encheres INSERT INTO Articles_Vendus (nom_article, description, date_debut_encheres," +
                                    " date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)" +
                                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String DELETE = "USE Encheres DELETE FROM Articles_Vendus WHERE no_article = ?";

    @Override
    public Articles_Vendus selectById(int id) throws DALException {
        Articles_Vendus articles_Vendus = null;
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int no_article = rs.getInt("no_article");
                String nom_article = rs.getString("nom_article");
                String description = rs.getString("description");
                LocalDate date_debut_encheres = rs.getDate("date_debut_encheres").toLocalDate();
                LocalDate date_fin_encheres = rs.getDate("date_fin_encheres").toLocalDate();
                int prix_initial = rs.getInt("prix_initial");
                int prix_vente = rs.getInt("prix_vente");
                int no_utilisateur = rs.getInt("no_utilisateur");
                int no_categorie = rs.getInt("no_categorie");
                articles_Vendus = new Articles_Vendus();
                articles_Vendus.setNo_article(no_article);
                articles_Vendus.setNom_article(nom_article);
                articles_Vendus.setDescription(description);
                articles_Vendus.setDate_debut_encheres(date_debut_encheres);
                articles_Vendus.setDate_fin_encheres(date_fin_encheres);
                articles_Vendus.setPrix_initial(prix_initial);
                articles_Vendus.setPrix_vente(prix_vente);
                articles_Vendus.setUtilisateur(DAOFact.getUtilisateursDAO().selectById(no_utilisateur));
                articles_Vendus.setNo_categorie(no_categorie); // TODO A changer quand catégorie sera fait
                try{
                articles_Vendus.setRetrait(DAOFact.getRetraitsDAO().selectById(no_article));
                }
                catch (Exception e) {

                    articles_Vendus.setRetrait(null);
                }
                try{
                    articles_Vendus.setListEnchere(DAOFact.getEncheresDAO().selectAllByIdArticle(no_article));
                    articles_Vendus.setEnchereMax( Collections.max(articles_Vendus.getListEnchere(), Comparator.comparing(c -> c.getMontant_enchere())));
                }
                catch (Exception e) {
                    articles_Vendus.setEnchereMax(null);
                    articles_Vendus.setListEnchere(null);
                }
                articles_Vendus.setCategorie(DAOFact.getCategoriesDAO().selectById(no_categorie));
            }

            if (articles_Vendus == null)
                throw new DALException("Il n'y a pas d'article avec cet id");
            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection d'un article");
        }
        return articles_Vendus;
    }

    @Override
    public List<Articles_Vendus> selectAll() throws DALException {
        List<Articles_Vendus> listeArticles_Vendus = new ArrayList<Articles_Vendus>();
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int no_article = rs.getInt("no_article");
                String nom_article = rs.getString("nom_article");
                String description = rs.getString("description");
                LocalDate date_debut_encheres = rs.getDate("date_debut_encheres").toLocalDate();
                LocalDate date_fin_encheres = rs.getDate("date_fin_encheres").toLocalDate();
                int prix_initial = rs.getInt("prix_initial");
                int prix_vente = rs.getInt("prix_vente");
                int no_utilisateur = rs.getInt("no_utilisateur");
                int no_categorie = rs.getInt("no_categorie");
                Articles_Vendus articles_Vendus = new Articles_Vendus();
                articles_Vendus = new Articles_Vendus();
                articles_Vendus.setNo_article(no_article);
                articles_Vendus.setNom_article(nom_article);
                articles_Vendus.setDescription(description);
                articles_Vendus.setDate_debut_encheres(date_debut_encheres);
                articles_Vendus.setDate_fin_encheres(date_fin_encheres);
                articles_Vendus.setPrix_initial(prix_initial);
                articles_Vendus.setPrix_vente(prix_vente);
                articles_Vendus.setUtilisateur(DAOFact.getUtilisateursDAO().selectById(no_utilisateur));
                articles_Vendus.setCategorie(DAOFact.getCategoriesDAO().selectById(no_categorie));
                articles_Vendus.setNo_categorie(no_categorie);
                try{
                    articles_Vendus.setRetrait(DAOFact.getRetraitsDAO().selectById(no_article));}
                catch (Exception e) {

                    articles_Vendus.setRetrait(null);
                }
                try{
                    articles_Vendus.setListEnchere(DAOFact.getEncheresDAO().selectAllByIdArticle(no_article));
                    articles_Vendus.setEnchereMax( Collections.max(articles_Vendus.getListEnchere(), Comparator.comparing(c -> c.getMontant_enchere())));
                }
                catch (Exception e) {
                    articles_Vendus.setEnchereMax(null);
                    articles_Vendus.setListEnchere(null);
                }
                listeArticles_Vendus.add(articles_Vendus);

            }
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection des articles");
        }
        return listeArticles_Vendus;
    }

    @Override
    public void update(Articles_Vendus article_vendu) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);
            stmt.setString(1, article_vendu.getNom_article());
            stmt.setString(2, article_vendu.getDescription());
            stmt.setDate(3, Date.valueOf(article_vendu.getDate_debut_encheres()));
            stmt.setDate(4, Date.valueOf(article_vendu.getDate_fin_encheres()));
            stmt.setInt(5, article_vendu.getPrix_initial());
            stmt.setInt(6, article_vendu.getPrix_vente());
            stmt.setInt(7, article_vendu.getUtilisateur().getNo_utilisateur());
            stmt.setInt(8, article_vendu.getNo_categorie());
            stmt.executeUpdate();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la mise à jour d'un article");
        }
    }

    @Override
    public Articles_Vendus insert(Articles_Vendus article_vendu) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);


            stmt.setString(1, article_vendu.getNom_article());
            stmt.setString(2, article_vendu.getDescription());
            stmt.setDate(3, Date.valueOf(article_vendu.getDate_debut_encheres()));
            stmt.setDate(4, Date.valueOf(article_vendu.getDate_fin_encheres()));
            stmt.setInt(5, article_vendu.getPrix_initial());
            stmt.setInt(6, article_vendu.getPrix_vente());
            stmt.setInt(7, article_vendu.getUtilisateur().getNo_utilisateur());
            stmt.setInt(8, article_vendu.getNo_categorie());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            article_vendu.setNo_article(generatedKey);

            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans l'insertion d'un article");
        }
        return article_vendu;
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
            throw new DALException("Problème dans la suppression d'un article");

        }

    }

}
