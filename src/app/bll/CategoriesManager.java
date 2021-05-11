package app.bll;

import app.bo.Categories;
import app.dal.DALException;
import app.dal.DAOFact;

import java.util.List;

public class CategoriesManager implements ICategoriesManager {


    @Override
    public List<Categories> recupererCategories() throws BusinessException, DALException {
        try {
            return DAOFact.getCategoriesDAO().selectAll();
        } catch (Exception e) {
            throw new BusinessException("Catégories non récupérées", "Problème dans le récupération des catégories");
        }
    }

    @Override
    public Categories recupererCategorie(int id) throws BusinessException, DALException {
        try {
            return DAOFact.getCategoriesDAO().selectById(id);
        } catch (Exception e) {
            throw (e);
        }
    }
}
