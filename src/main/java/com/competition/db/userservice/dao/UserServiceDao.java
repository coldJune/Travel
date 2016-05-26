package com.competition.db.userservice.dao;

import com.competition.db.pojo.User;
/**
 * 
 * @author 笨蛋
 *@version 1.0
 *@date 2016/5/26
 */
public interface UserServiceDao {
		public boolean checkName(String  name);
		public boolean checkPass(String namer,String pass);
		public boolean addUser(User user);
		public boolean updateUser(User user);
		public boolean getAll();
		
}
