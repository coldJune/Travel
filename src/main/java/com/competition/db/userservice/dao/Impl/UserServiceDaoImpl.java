package com.competition.db.userservice.dao.Impl;

import com.competition.db.pojo.User;
import com.competition.db.user.dao.UserDao;
import com.competition.db.user.dao.impl.UserDaoImpl;
import com.competition.db.userservice.dao.UserServiceDao;

public class UserServiceDaoImpl implements UserServiceDao {
	private UserDao<User> userDao = new UserDaoImpl();
	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		User user =(User) userDao.findUserByName(name);
		if(user.getM_sUserName()!=null){
			return true;
		}
		return false;
	}

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

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUserByUsrObj(user);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUserByUsrObj(user);
		return false;
	}

	@Override
	public boolean getAll() {
		// TODO Auto-generated method stub
		userDao.getAll();
		return false;
	}

}
