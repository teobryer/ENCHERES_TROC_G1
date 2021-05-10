package app.bll;

import app.bo.Articles_Vendus;
import app.bo.Retraits;


import java.util.List;


public interface IArticles_VendusManager {

    /**
     * Ajouter un article sur la Plateforme ENI-Enchères (Id: 2001)
     * @param retrait adresse de retrait de l'article
     * @param article article mis en vente aux enchères
     * @return l'article ajouté dans la liste des articles à vendre
     * @throws BusinessException
     */
    Articles_Vendus vendreUnArticle(Articles_Vendus article, Retraits retrait) throws BusinessException;

    /**
     *
     * @return Renvoie la liste des tous les articles en ventes
     * @throws BusinessException
     */
    List<Articles_Vendus> recupererLesArticles()  throws BusinessException;

    Articles_Vendus recupererArticleParId(int id) throws BusinessException;
}
