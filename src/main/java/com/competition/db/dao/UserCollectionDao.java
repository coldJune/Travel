package com.competition.db.dao;

import java.util.List;

import com.competition.db.common.BasicDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserCollection;

public interface UserCollectionDao extends BasicDao<UserCollection>{
	/**
	 * 
	 * @param collection
	 * @param user			曾经持久化
	 */
	public void addCollectionByColObj(UserCollection collection,User user);
	
	/**
	 * 		
	 * @param collection 	曾经持久化
	 */
	public void deleteCollectionByColObj(UserCollection collection);
	
	/**
	 * 
	 * @param user 			必须是一个托管对象
	 * @return
	 */
	public List<UserCollection> findAllCollectionByUsrObj(User user);
	
	//改
//	public void updateCollectionByColObj(UserCollection collection);
	
}
