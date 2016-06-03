package com.competition.db.dao.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import com.competition.db.common.BasicOperation;
import com.competition.db.dao.UserCollectionDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserCollection;



public class UserCollectionDaoImpl extends BasicOperation<UserCollection> implements UserCollectionDao{

	@Override
	public void addCollectionByColObj(UserCollection collection,User user) {
		// TODO Auto-generated method stub
		collection.setM_UUser(user);
		this.getSessionFactory().getCurrentSession().save(collection);
		
	}

	@Override
	public void deleteCollectionByColObj(UserCollection collection) {
		// TODO Auto-generated method stub
		this.getSessionFactory().getCurrentSession().delete(collection);
	}

	/**
	 * 找到一个用户的所有的收藏项
	 */
	@Override
	public List<UserCollection> findAllCollectionByUsrObj(User user) {
		// TODO Auto-generated method stub
		Set<UserCollection> collections_set = user.getM_UCUserCollection();
		List<UserCollection> collections_list = new ArrayList<UserCollection>();
		for(UserCollection ele : collections_set){
			UserCollection collection = ele;
			collections_list.add(collection);		
			}
		return collections_list;
	}

	@Override
	public void updateCollectionByColObj(UserCollection collection) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(collection);
	}
}
