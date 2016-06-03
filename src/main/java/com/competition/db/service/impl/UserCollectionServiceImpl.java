package com.competition.db.service.impl;

import java.util.List;

import com.competition.db.dao.UserCollectionDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserCollection;
import com.competition.db.service.UserCollectionService;

public class UserCollectionServiceImpl implements UserCollectionService {
	private UserCollectionDao userCollectionDao;
	public void setUserCollectionDao(UserCollectionDao userCollectionDao) {
		this.userCollectionDao = userCollectionDao;
	}

	@Override
	public void addCollectionByColObj(UserCollection collection, User user) {
		// TODO Auto-generated method stub
		userCollectionDao.addCollectionByColObj(collection, user);
	}

	@Override
	public void deleteCollectionByColObj(UserCollection collection) {
		// TODO Auto-generated method stub
		userCollectionDao.deleteCollectionByColObj(collection);
	}

	@Override
	public List<UserCollection> findAllCollectionByUsrObj(User user) {
		// TODO Auto-generated method stub
		return userCollectionDao.findAllCollectionByUsrObj(user);
	}

	@Override
	public void updateCollectionByColObj(UserCollection collection) {
		// TODO Auto-generated method stub

	}

}
