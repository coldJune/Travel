package com.competition.db.dao;

import com.competition.db.pojo.User;
import com.competition.db.pojo.UserRefreshInformation;

public interface UserRefreshInformationDao {
	
	/**
	 * 
	 * @param userRefreshInformation
	 */
	public void addUserRefreshInforByObj(UserRefreshInformation userRefreshInformation);
	
	/**
	 * 
	 * @param userRefreshInformation
	 */
	public void deleteUserRefreshInfor(UserRefreshInformation userRefreshInformation);
	
	/**
	 * 
	 * @param user
	 * @param ip
	 * @return
	 */
	public UserRefreshInformation findUserRefreshInfor(User user,String ip);
	
	
	
}
