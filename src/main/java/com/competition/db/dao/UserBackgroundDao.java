package com.competition.db.dao;

import java.util.List;

import com.competition.db.common.BasicDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserBackground;

public interface UserBackgroundDao extends BasicDao<UserBackground>{
	/**
	 * 
	 * @param user User必须曾经持久化
	 * @param background
	 */
	public boolean addBackgroundByUsrObj(User user,UserBackground background);
	
	/**
	 * 
	 * @param background 必须曾经持久化
	 */
	public boolean deleteBackgroundByBakObj(UserBackground background);
	
	/**
	 * 
	 * @param user 必须曾经持久化
	 * @return
	 */
	public List<UserBackground> findAllBackgroundByUsrObj(User user);
	
	//改
}
