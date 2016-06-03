package com.competition.db.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.competition.db.common.BasicOperation;
import com.competition.db.dao.UserCollectionDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserCollection;

public class UserCollectionDaoImpl extends BasicOperation<UserCollection> implements UserCollectionDao{

	@Override
	public void addCollectionByColObj(UserCollection collection,User user) {
		collection.setM_UUser(user);
		this.getSessionFactory().getCurrentSession().save(collection);
		
	}

	@Override
	public void deleteCollectionByColObj(UserCollection collection) {
		this.getSessionFactory().getCurrentSession().delete(collection);
	}

	/**
	 * 找到一个用户的所有的收藏项
	 */
	@Override
	public List<UserCollection> findAllCollectionByUsrObj(User user) {
		this.getSessionFactory().getCurrentSession().update(user);
		Set<UserCollection> collections_set = user.getM_UCUserCollection();

		List<UserCollection> collections_list = new ArrayList<UserCollection>();
		for(UserCollection ele : collections_set){
			collections_list.add(ele);		
			}
		return collections_list;
	}
}
