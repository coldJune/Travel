package com.competition.db.dao;


import java.util.List;

import com.competition.db.common.BasicDao;



public interface UserDao<User> extends BasicDao<User>{
	//增加一个用户
	/**
	 * 
	 * @param user
	 * @return
	 */
	public Integer addUserByUsrObj(User user);
	
	
	//删除一个用户
	/**
	 * 
	 * @param user
	 */
	public void deleteUserByUsrObj(User user);
	
	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return
	 */
	public User findUserByName(String name);
	
	public User findUserByNameAndPass(User user);
	
	//得到基本信息
	
	//更新一个用户的信息
	public void updateUserByUsrObj(User user);
	
	//得到所用的用户
	public List<User> getAll();
}
