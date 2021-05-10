package app.bll;

import app.bo.Categories;

import app.dal.DALException;

import java.util.List;

public interface ICategoriesManager {

    List<Categories> recupererCategories() throws BusinessException, DALException;
    Categories recupererCategorie(int id) throws BusinessException, DALException;

}
