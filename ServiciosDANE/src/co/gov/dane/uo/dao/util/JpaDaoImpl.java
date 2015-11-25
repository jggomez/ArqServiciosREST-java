package co.gov.dane.uo.dao.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author <a href="mailto:dgomez@vortexbird.com">Diego A Gomez</a>
 * @project zathuracode
 * @class JpaDaoImpl
 * @date Nov 01, 2013
 *
 */
@SuppressWarnings({ "unchecked" })
public class JpaDaoImpl<T, PK extends Serializable> implements Dao<T, PK> {

	private Class<T> entityClass;
	// private Logger log = null;
	private int maxResults = 0;
	private EntityManager em;

	public JpaDaoImpl() {
		super();
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		// log = LoggerFactory.getLogger(entityClass);
		em = EntityManagerHelper.getEntityManager();
	}

	public void save(T newEntity) throws DaoException {
		em.persist(newEntity);
	}

	public T findById(PK id) {
		return (T) em.find(entityClass, id);
	}

	public void update(T entity) throws DaoException {
		em.merge(entity);
	}

	public void delete(T entity) throws DaoException {
		em.remove(entity);
	}

	public void deleteById(PK id) throws DaoException {
		T toRemove = findById(id);
		em.remove(toRemove);
	}

	public void deleteByProperty(String tableName, String propertyName,
			Object value) throws DaoException {
		String queryString = "delete from " + tableName
				+ " as model where model." + propertyName + "= ?0";
		Query queryObject = em.createQuery(queryString);
		queryObject.setParameter(0, value);
		queryObject.executeUpdate();
	}

	public void deleteAll() throws DaoException {
		String queryString = "delete from " + entityClass.getName();
		Query queryObject = em.createQuery(queryString);
		queryObject.executeUpdate();
	}

	public Long count() {
		Query query = createQuery("select count(*) from "
				+ entityClass.getName());
		Long result = (Long) query.getSingleResult();

		return (result != null) ? result : 0;
	}

	protected Query createQuery(String queryString) {
		Query query = em.createQuery(queryString);
		prepareQuery(query);

		return query;
	}

	protected void prepareQuery(Query queryObject) {
		if (getMaxResults() > 0) {
			queryObject.setMaxResults(getMaxResults());
		}
	}

	public List<T> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> root = cq.from(entityClass);

		return em.createQuery(cq.select(root)).getResultList();
	}

	public List<T> findPage(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) {
		// log.debug("findPage " + entityClass.getName());

		if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
			try {
				String queryString = "select model from "
						+ entityClass.getName() + " model order by model."
						+ sortColumnName + " "
						+ (sortAscending ? "asc" : "desc");

				Query queryObject = em.createQuery(queryString);
				queryObject.setFirstResult(startRow);
				queryObject.setMaxResults(maxResults);

				return queryObject.getResultList();
			} catch (RuntimeException re) {
				throw re;
			}
		} else {
			try {
				String queryString = "select model from "
						+ entityClass.getName() + " model";

				Query queryObject = em.createQuery(queryString);
				queryObject.setFirstResult(startRow);
				queryObject.setMaxResults(maxResults);

				return queryObject.getResultList();
			} catch (RuntimeException re) {
				// log.error("findPage " + entityClass.getName() + " failed",
				// re);
				throw re;
			}
		}
	}

	public List<T> findByCriteria(String whereCondition) {
		// log.debug("finding " + entityClass.getName() + " " + whereCondition);

		try {
			String where = ((whereCondition == null) || (whereCondition
					.length() == 0)) ? "" : ("where " + whereCondition);
			final String queryString = "select model from "
					+ entityClass.getName() + " model " + where;

			Query queryObject = em.createQuery(queryString);

			return queryObject.getResultList();
		} catch (RuntimeException re) {
			// log.error("find By Criteria failed", re);
			throw re;
		}
	}

	public List<T> findByProperty(String propertyName, Object value) {
		// log.debug("finding " + entityClass.getName() +
		// " instance with property: " + propertyName + ", value: " + value);

		try {
			String queryString = "select model from " + entityClass.getName()
					+ " as model where model." + propertyName + "= ?0";
			Query queryObject = em.createQuery(queryString);
			queryObject.setParameter(0, value);

			return queryObject.getResultList();
		} catch (RuntimeException re) {
			// log.error("find by property name failed", re);
			throw re;
		}
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
}