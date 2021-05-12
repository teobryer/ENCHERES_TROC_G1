package app.dal;

import app.bo.Enchere;
import app.bo.Utilisateurs;

import java.util.List;

public interface DAOEncheres  extends DAO<Enchere>{

    List<Enchere> selectAllByIdArticle(int id)  throws DALException;
}
