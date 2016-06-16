package com.competition.db.service;

import com.competition.db.pojo.User;
import com.competition.db.pojo.UserRefreshInformation;

public interface UserRefreshInformationService {
	/**
	 * 添加用户登陆信息
	 * @param userRefreshInfro
	 */
	public void addUserRefreshInforByObj(UserRefreshInformation userRefreshInfro);
	
	/**
	 * 删除用户登陆信息
	 * @param userRefreshInfor
	 */
	public void deleteRefreshInfor(UserRefreshInformation userRefreshInfor);
	
	/**
	 * 查找用户某个ip的网页的最新登陆信息
	 * @param user
	 * @param ip
	 * @return
	 */
	public UserRefreshInformation findUserRefreshInformation(User user,String ip);
}
