package net.luis.common.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @CreateTime：2017年3月28日 下午4:45:19
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.dao
 * @FileName：HIbernateAbstractDao.java @Description：
 */

public abstract interface HibernateAbstractDao<T, ID extends Serializable> {
	public abstract void save(T paramT);

	public abstract void saveOrUpdate(T paramT);

	public abstract T load(ID paramID);

	public abstract T get(ID paramID);

	public abstract boolean contains(T paramT);

	public abstract void delete(T paramT);

	public abstract boolean deleteById(ID paramID);

	public abstract void deleteAll(Collection<T> paramCollection);

	public abstract void queryHql(String paramString, Object[] paramArrayOfObject);

	public abstract void querySql(String paramString, Object[] paramArrayOfObject);

	public abstract T getByHQL(String paramString, Object[] paramArrayOfObject);

	public abstract T getBySQL(String paramString, Object[] paramArrayOfObject);

	public abstract List<T> getListByHQL(String paramString, Object[] paramArrayOfObject);

	public abstract List<T> getListBySQL(String paramString, Object[] paramArrayOfObject);

	public abstract List findListBySql(String paramString, RowMapper paramRowMapper, Object[] paramArrayOfObject);

	public abstract void refresh(T paramT);

	public abstract void update(T paramT);

	public abstract Long countByHql(String paramString, Object[] paramArrayOfObject);

	public abstract PageResults<T> findPageByFetchedHql(String paramString1, String paramString2, int paramInt1,
			int paramInt2, Object[] paramArrayOfObject);
}