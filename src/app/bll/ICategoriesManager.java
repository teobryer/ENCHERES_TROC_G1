package app.bll;

import app.bo.Categories;

import app.dal.DALException;

import java.util.List;

public interface ICategoriesManager {

    /**
     * Renvoie la liste des catégories
     * @return
     * @throws BusinessException
     * @throws DALException
     */
    List<Categories> recupererCategories() throws BusinessException, DALException;

    /**
     * Récupère une catégorie à partir de son identifiant
     * @param id
     * @return
     * @throws BusinessException
     * @throws DALException
     */
    Categories recupererCategorie(int id) throws BusinessException, DALException;

}
