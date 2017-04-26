package net.luis.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.luis.common.dao.HibernateBaseDao;
import net.luis.common.dao.Page;
import net.luis.common.dao.PropertyFilter;

/**
 * 基础service 所有service继承该类,提供基础的实体操作方法
 * 使用HibernateDao<T,PK>进行业务对象的CRUD操作,子类需重载getEntityDao()函数提供该DAO.
 * @author liusai
 * @date 2014年8月20日 上午11:21:14
 * @param <T>
 * @param <PK>
 */
public abstract class BaseService<T,PK extends Serializable > {
	
	/**子类需要实现该方法，提供注入的dao
	 * @return
	 */
	public abstract HibernateBaseDao<T, PK> getEntityDao();
	
	@Transactional(readOnly = true)
	public T get(final PK id) {
		return this.getEntityDao().find(id);
	}

	@Transactional(readOnly = false)
	public void save(final T entity) {
		this.getEntityDao().save(entity);
	}
	
	@Transactional(readOnly = false)
	public void update(final T entity){
		this.getEntityDao().save(entity);
	}
	
	@Transactional(readOnly = false)
	public void delete(final T entity){
		this.getEntityDao().delete(entity);
	}
	
	@Transactional(readOnly = false)
	public void delete(final PK id){
		this.getEntityDao().delete(id);
	}
	
	@Transactional(readOnly = true)
	public List<T> getAll(){
		return this.getEntityDao().findAll();
	}
	
	@Transactional(readOnly = true)
	public List<T> getAll(Boolean isCache){
		return this.getEntityDao().findAll(isCache);
	}
	
	
	public List<T> search(final List<PropertyFilter> filters){
		return this.getEntityDao().find(filters);
	}
	
	
	@Transactional(readOnly = true)
	public Page<T> search(final Page<T> page, final List<PropertyFilter> filters) {
		return this.getEntityDao().findPage(page, filters);
	}
	
	
/*	@Transactional(readOnly = true)
	public Page<T> search(final Page<T> page, final String hql,final Map<String, ?> values) {
		return getEntityDao().findPage(page, hql, values);
	}
	
	@Transactional(readOnly = true)
	public Page<T> search(final Page<T> page, final String hql,final Object... values) {
		return getEntityDao().findPage(page, hql, values);
	}*/
	
}
