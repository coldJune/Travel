package com.competition.db.service.impl;

import com.competition.db.dao.UserRefreshInformationDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserRefreshInformation;
import com.competition.db.service.UserRefreshInformationService;

public class UserRefreshInformationServiceImpl implements UserRefreshInformationService {
	
	private UserRefreshInformationDao userRefreshInformationDao;

	@Override
	public void addUserRefreshInforByObj(UserRefreshInformation userRefreshInfor) {
		// TODO Auto-generated method stub
		userRefreshInformationDao.addUserRefreshInforByObj(userRefreshInfor);
		
	}

	@Override
	public void deleteRefreshInfor(UserRefreshInformation userRefreshInfor) {
		// TODO Auto-generated method stub
		userRefreshInformationDao.deleteUserRefreshInfor(userRefreshInfor);
		
	}

	@Override
	public UserRefreshInformation findUserRefreshInformation(User user,
			String ip) {
		// TODO Auto-generated method stub
		return userRefreshInformationDao.findUserRefreshInfor(user, ip);
	}
}
