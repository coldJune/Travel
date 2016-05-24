package com.competition.db.usercollection.dao;



import java.util.List;

import com.competition.db.common.BasicDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserCollection;


public interface UserCollectionDao extends BasicDao<UserCollection>{
	//增
	public void addCollectionByColObj(UserCollection collection,User user);
	
	//删
	public void deleteCollectionByColObj(UserCollection collection);
	
	//查
	public List<UserCollection> findAllCollectionByUsrObj(User user);
	
	//改
	public void updateCollectionByColObj(UserCollection collection);
	
}

