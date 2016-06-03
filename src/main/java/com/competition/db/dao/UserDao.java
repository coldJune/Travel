package com.competition.db.dao;

import java.util.List;

import com.competition.db.common.BasicDao;

public interface UserDao<User> extends BasicDao<User>{
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
	
	/**
	 * 根据用户名和密码查找是否用户
	 * @param user
	 * @return
	 */
	public User findUserByNameAndPass(User user);
	
	/**
	 * 
	 * @param user
	 */
	public void updateUserByUsrObj(User user);
	
	/**
	 * 
	 * @return
	 */
	public List<User> getAll();
}
