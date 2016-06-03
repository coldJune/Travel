package com.competition.db.dao.impl;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.competition.db.common.BasicOperation;
import com.competition.db.dao.UserDao;
import com.competition.db.pojo.User;

public class UserDaoImpl extends BasicOperation<User> implements UserDao<User> {

	@Override
	public Integer addUserByUsrObj(User user) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = getSessionFactory();
		if(sessionFactory != null){
			System.out.println("获取SessionFactory成功！");
		}else{
			System.out.println("获取SessionFactory失败！");
		}
		Session sess = sessionFactory.getCurrentSession();
		Integer id = (Integer)sess.save(user);
		return id;
	}

	@Override
	public void deleteUserByUsrObj(User user) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(user);
	}


	@Override
	public void updateUserByUsrObj(User user) {
		System.out.println(".............");
		getSessionFactory().getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		String hql = "select distinct user from User as user where user.m_sUserName=?0";		
		List<User> result = find(hql,name); 
		if(result !=null && result.size() != 0){
			return result.get(0);
		}
		return null;
	}
	
	@Override
	public User findUserByNameAndPass(User user) {
		// TODO Auto-generated method stub
		String hql="select distinct user from User user where user.m_sUserName=?0 and user.m_sUserPass=?1";
		List<User> result = find(hql, user.getM_sUserName(),user.getM_sUserPass());
		if(result!=null && result.size() != 0)
			return result.get(0);
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		String sqlAll = "select distinct user from User as user";
		List l = getSessionFactory().getCurrentSession().createQuery(sqlAll).list();
		List<User> result = new ArrayList<User>();
		for(Object ele:l){
			User user = (User)ele;
			result.add(user);
		}
		
		return result;
	}

	
}
