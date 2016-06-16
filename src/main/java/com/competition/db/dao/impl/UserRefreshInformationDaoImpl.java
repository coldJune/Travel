package com.competition.db.dao.impl;

import java.util.Set;

import com.competition.db.common.BasicOperation;
import com.competition.db.dao.UserRefreshInformationDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserRefreshInformation;

public class UserRefreshInformationDaoImpl extends BasicOperation implements UserRefreshInformationDao{

	@Override
	public void addUserRefreshInforByObj(
			UserRefreshInformation userRefreshInformation) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(userRefreshInformation);
		
	}

	@Override
	public void deleteUserRefreshInfor(
			UserRefreshInformation userRefreshInformation) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(userRefreshInformation);
		
	}

	@Override
	public UserRefreshInformation findUserRefreshInfor(User user, String ip){
//		// TODO Auto-generated method stub
//		String hql = "select userRefreshInfor from UserRefreshInfor as userRefreshInfor where user.m_sUserName=?0";
//		List
//		return null;
		Set<UserRefreshInformation> userRefreshInformations =user.getUserRefreshInformation();
		for(UserRefreshInformation userRefreshInformation: userRefreshInformations){
			if(userRefreshInformation.getM_SIp() == ip){
				return userRefreshInformation;
			}else{
				return null;
			}
		}
		return null;
	}

}
