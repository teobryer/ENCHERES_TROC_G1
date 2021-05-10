package app.bll;

import app.bo.Articles_Vendus;
import app.bo.Utilisateurs;


import java.util.Date;
import java.util.List;


public interface IArticles_VendusManager {

    /**
     * Ajouter un article sur la Plateforme ENI-Enchères (Id: 2001)
     *
     * @param nom_article         nom de l'article
     * @param description         description de l'article
     * @param no_categorie        Catégorie de l'article TODO A remplacer
     * @param prixDeDepart        prix de départ EN POINTS de l'article
     * @param date_debut_encheres date et heure d'ouverture de l'enchère pour cet article
     * @param date_fin_encheres   date et heure de la fin de l'enchère pour cet article
     * @param rueRecup            rue de récupération de l'article - par défaut celle du vendeur
     * @param cpRecup             Code Postal de récupération de l'article - par défaut celle du vendeur
     * @param villeRecup          Ville de récupération de l'article - par défaut celle du vendeur
     * @param vendeur             Automatiquement set - vendeur de l'article
     * @return l'article ajouté dans la liste des articles à vendre
     * @throws BusinessException
     */
    Articles_Vendus vendreUnArticle(String nom_article, String description, int no_categorie, int prixDeDepart,
                                    Date date_debut_encheres, Date date_fin_encheres, String rueRecup, String cpRecup,
                                    String villeRecup, Utilisateurs vendeur) throws BusinessException;

    /**
     *
     * @return Renvoie la liste des tous les articles en ventes
     * @throws BusinessException
     */
    List<Articles_Vendus> recupererLesArticles()  throws BusinessException;

    Articles_Vendus recupererArticleParId(int id) throws BusinessException;
}
