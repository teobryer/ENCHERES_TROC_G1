package app.bll;

import app.bo.Articles_Vendus;
import app.bo.Retraits;
import app.bo.Utilisateurs;
import app.dal.DAOFact;

import java.util.Date;
import java.util.List;

public class Articles_VendusManager implements IArticles_VendusManager {

    @Override
    public Articles_Vendus vendreUnArticle(String nom_article, String description, int no_categorie,
                                           int prixDeDepart, Date date_debut_encheres, Date date_fin_encheres,
                                           String rueRecup, String cpRecup, String villeRecup, Utilisateurs vendeur)
            throws BusinessException {

        Articles_Vendus nouvelArticle = new Articles_Vendus();
        nouvelArticle.setNom_article(nom_article);
        nouvelArticle.setDescription(description);
        nouvelArticle.setDate_debut_encheres(date_debut_encheres);
        nouvelArticle.setDate_fin_encheres(date_fin_encheres);
        nouvelArticle.setPrix_initial(prixDeDepart);
        nouvelArticle.setPrix_vente((Integer) null);
        nouvelArticle.setUtilisateur(vendeur);
        nouvelArticle.setNo_categorie(no_categorie);
        Retraits adresseDeRetrait = new Retraits();
        adresseDeRetrait.setRue(rueRecup);
        adresseDeRetrait.setCode_postal(cpRecup);
        adresseDeRetrait.setVille(villeRecup);

        try {
            return DAOFact.getArticlesDAO().insert(nouvelArticle);
        } catch (Exception e) {
            throw new BusinessException("Article non inséré", "Problème lors de l'insertion de l'article");
        }
    }

    @Override
    public List<Articles_Vendus> recupererLesArticles() throws BusinessException {
        try{
         return DAOFact.getArticlesDAO().selectAll();
        }

        catch (Exception e){
            throw new BusinessException("Articles non récupérées", "Problème dans le récupération des articles");
        }
    }
}
