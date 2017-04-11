package net.luis.common.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @CreateTime：2017年3月28日 下午4:46:08
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.dao.HibernateBaseDao.java 
 * @Description：
 */

public class HibernateBaseDao<T, ID extends Serializable> implements HibernateAbstractDao<T, ID> {

	@Autowired
	private SessionFactory sessionFactory;
	protected Class<T> entityClass;

	protected Class getEntityClass() {
		if (this.entityClass == null) {
			this.entityClass = ((Class) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0]);
		}
		return this.entityClass;
	}

	public void save(T t) {
		getSession().save(t);
	}

	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}

	public T load(ID id) {
		Object load = getSession().load(getEntityClass(), id);
		return (T) load;
	}

	public T get(ID id) {
		Object load = getSession().get(getEntityClass(), id);
		return (T) load;
	}

	public boolean contains(T t) {
		return getSession().contains(t);
	}

	public void delete(T t) {
		getSession().delete(t);
	}

	public boolean deleteById(ID Id) {
		Object t = get(Id);
		if (t == null) {
			return false;
		}
		delete((T) t);
		return true;
	}

	public void deleteAll(Collection<T> entities) {
		for (Iterator localIterator = entities.iterator(); localIterator.hasNext();) {
			Object entity = localIterator.next();
			getSession().delete(entity);
		}
	}

	public void queryHql(String hqlString, Object[] values) {
		Query query = getSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.executeUpdate();
	}

	public void querySql(String sqlString, Object[] values) {
		Query query = getSession().createSQLQuery(sqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.executeUpdate();
	}

	public T getByHQL(String hqlString, Object[] values) {
		Query query = getSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return (T) query.uniqueResult();
	}

	public T getBySQL(String sqlString, Object[] values) {
		Query query = getSession().createSQLQuery(sqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return (T) query.uniqueResult();
	}

	public List<T> getListByHQL(String hqlString, Object[] values) {
		Query query = getSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	public List<T> getListBySQL(String sqlString, Object[] values) {
		Query query = getSession().createSQLQuery(sqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}


	public void refresh(T t) {
		getSession().refresh(t);
	}

	public void update(T t) {
		getSession().update(t);
	}

	public Long countByHql(String hql, Object[] values) {
		Query query = getSession().createQuery(hql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return (Long) query.uniqueResult();
	}

	public PageResults<T> findPageByFetchedHql(String hql, String countHql, int pageNo, int pageSize, Object[] values) {
		PageResults retValue = new PageResults();
		Query query = getSession().createQuery(hql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		int currentPage = pageNo > 1 ? pageNo : 1;
		retValue.setCurrentPage(currentPage);
		retValue.setPageSize(pageSize);
		if (countHql == null) {
			ScrollableResults results = query.scroll();
			results.last();
			retValue.setTotalCount(results.getRowNumber() + 1);
		} else {
			Long count = countByHql(countHql, values);
			retValue.setTotalCount(count.intValue());
		}
		retValue.resetPageNo();
		List itemList = query.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).list();
		if (itemList == null) {
			itemList = new ArrayList();
		}
		retValue.setResults(itemList);
		return retValue;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	private void setParameter(PreparedStatement ps, int pos, Object data) throws SQLException {
		if (data == null) {
			ps.setNull(pos + 1, 12);
			return;
		}
		Class dataCls = data.getClass();
		if (String.class.equals(dataCls)) {
			ps.setString(pos + 1, (String) data);
		} else if (Boolean.TYPE.equals(dataCls)) {
			ps.setBoolean(pos + 1, ((Boolean) data).booleanValue());
		} else if (Integer.TYPE.equals(dataCls)) {
			ps.setInt(pos + 1, ((Integer) data).intValue());
		} else if (Double.TYPE.equals(dataCls)) {
			ps.setDouble(pos + 1, ((Double) data).doubleValue());
		} else if (Date.class.equals(dataCls)) {
			Date val = (Date) data;
			ps.setTimestamp(pos + 1, new Timestamp(val.getTime()));
		} else if (BigDecimal.class.equals(dataCls)) {
			ps.setBigDecimal(pos + 1, (BigDecimal) data);
		} else {
			ps.setObject(pos + 1, data);
		}
	}

	@Override
	public List findListBySql(String paramString, RowMapper paramRowMapper, Object[] paramArrayOfObject) {
		// TODO Auto-generated method stub
		return null;
	}
}