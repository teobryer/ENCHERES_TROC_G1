package app.dal;


import java.util.List;

public interface DAO<E> {

    E selectById(int id) throws DALException;

    List<E> selectAll() throws DALException;

    void update(E e) throws DALException;

    E insert(E e) throws DALException;

    void delete(int id) throws DALException;

}