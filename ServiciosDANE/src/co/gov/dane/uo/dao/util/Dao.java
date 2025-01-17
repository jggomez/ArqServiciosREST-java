package co.gov.dane.uo.dao.util;

import java.io.Serializable;

import java.util.List;


/**
 *
 * @author <a href="mailto:dgomez@vortexbird.com">Diego A Gomez</a>
 * @project zathuracode
 * @class Dao
 *
 */
public interface Dao<T, PK extends Serializable> {
    void save(T newEntity) throws DaoException;

    T findById(PK id);

    void update(T entity) throws DaoException;

    void delete(T entity) throws DaoException;

    void deleteById(PK id) throws DaoException;

    void deleteByProperty(String tableName, String propertyName, Object value)
        throws DaoException;

    void deleteAll() throws DaoException;

    Long count();

    List<T> findAll();

    List<T> findPage(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults);

    List<T> findByCriteria(String whereCondition);

    List<T> findByProperty(String propertyName, Object value);
}

