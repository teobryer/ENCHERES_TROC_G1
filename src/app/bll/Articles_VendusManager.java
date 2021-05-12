package app.bll;

import app.bo.Articles_Vendus;
import app.bo.Retraits;
import app.dal.DALException;
import app.dal.DAOFact;

import java.util.List;

public class Articles_VendusManager implements IArticles_VendusManager {

    @Override
    public Articles_Vendus vendreUnArticle(Articles_Vendus article, Retraits adresse_de_retrait) throws BusinessException {

        try {
            article = DAOFact.getArticlesDAO().insert(article);
            adresse_de_retrait.setNo_article(article.getNo_article());
            adresse_de_retrait = DAOFact.getRetraitsDAO().insert(adresse_de_retrait);
        } catch (DALException e) {
            throw new BusinessException("Article non inséré","Problème lors de l'ajout de l'article.");
        }
        return article;
    }

    @Override
    public List<Articles_Vendus> recupererLesArticles() throws BusinessException {
        try{
         return DAOFact.getArticlesDAO().selectAll();
        }

        catch (Exception e){
            throw new BusinessException("Articles non récupérés", "Problème dans le récupération des articles");
        }
    }

    @Override
    public Articles_Vendus recupererArticleParId(int id) throws BusinessException {
        try{
            return DAOFact.getArticlesDAO().selectById(id);
        }

        catch (Exception e){
            throw new BusinessException("Articles non récupéré", "Problème dans le récupération de l'article"+id);
        }
    }
}
