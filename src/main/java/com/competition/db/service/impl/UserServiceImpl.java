package com.competition.db.service.impl;

import java.util.List;

import com.competition.db.dao.UserDao;
import com.competition.db.pojo.User;
import com.competition.db.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao<User> userDao;
	
	public void setUserDao(UserDao<User> userDao) {
		this.userDao = userDao;
	}
	/**
	 * 检查名字是否存在
	 */
	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		User user =(User) userDao.findUserByName(name);
		if(user.getM_sUserName()!=null){
			return true;
		}
		return false;
	}
	/**
	 * 检查名字和密码是否匹配
	 */

	@Override
	public boolean checkPass(String name,String psw) {
		// TODO Auto-generated method stub
			User user =(User) userDao.findUserByName(name);
			if(psw==null){
				return false;
			}
			if(psw!=user.getM_sUserPass()){
				return false;
			}
			return true;
	}
	/**
	 * 添加用户
	 */
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUserByUsrObj(user);
		
	}
	/**
	 * 更新用户信息
	 */
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUserByUsrObj(user);
		
	}
	/**
	 * 得到所有用户信息
	 */
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
		
	}

}
