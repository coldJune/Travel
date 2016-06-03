package com.competition.db.common;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class BasicOperation<T> implements BasicDao<T>{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	/**
	 * 根据Id加载实体
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id) {
		// TODO Auto-generated method stub
		return (T)getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	/**
	 * 保存实体
	 */
	@Override
	public Serializable save(T entity) {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().save(entity);
	}

	/**
	 * 更新实体
	 */
	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	/**
	 * 删除实体
	 */
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(entity);
	}

	/**
	 * 根据Id删除实体
	 */
	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().createQuery("delete" + entityClazz.getSimpleName() + "en where en.id = ?0")
			.setParameter("0", id).executeUpdate();
	}

	/**
	 * 加载所有实体
	 */
	@Override
	public List<T> findAll(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	/**
	 * 获取实体总数
	 */
	@Override
	public long findCount(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		if(l != null && l.size() == 1){
			return (Long)l.get(0);
		}
		return 0;
	}
	
	/**
	 * 根据hql语句查询实体
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql){
		return (List<T>)getSessionFactory().getCurrentSession().createQuery(hql).list();
	}
	/**
	 * 根据带占位符参数的hql语句查询实体
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object...params){
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i=0, len=params.length;i<len; i++){
			query.setParameter(i+" ", params[i]);
		}
		return (List<T>)query.list();
	}
	

	/**
	 * 使用hql语句进行分页查询
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize){
		return getSessionFactory().getCurrentSession().createQuery(hql).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize)
				.list();
	}
	/**
	 * 使用带占位符的hql语句进行分页查询操作
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object...params){
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i=0, len=params.length; i<len; i++){
			query.setParameter(i + " ", params[i]);
		}
		return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
	}
	
}
