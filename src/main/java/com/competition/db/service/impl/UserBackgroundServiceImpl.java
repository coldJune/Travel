package com.competition.db.service.impl;

import java.util.List;

import com.competition.db.dao.UserBackgroundDao;
import com.competition.db.dao.impl.UserBackgroundDaoImpl;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserBackground;
import com.competition.db.service.UserBackgroundService;

public class UserBackgroundServiceImpl implements UserBackgroundService {
	private UserBackgroundDao userBackgroundDao;
	public void setUserBackgroundDao(UserBackgroundDao userBackgroundDao) {
		this.userBackgroundDao = userBackgroundDao;
	}

	@Override
	public void addBackgroundByUsrObj(User user, UserBackground background) {
		// TODO Auto-generated method stub
		userBackgroundDao.addBackgroundByUsrObj(user, background);
	}

	@Override
	public void deleteBackgroundByBakObj(UserBackground background) {
		// TODO Auto-generated method stub
		userBackgroundDao.deleteBackgroundByBakObj(background);
	}

	@Override
	public List<UserBackground> findAllBackgroundByUsrObj(User user) {
		// TODO Auto-generated method stub
		return userBackgroundDao.findAllBackgroundByUsrObj(user);
	}

}
