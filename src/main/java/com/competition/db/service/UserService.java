package com.competition.db.service;

import java.util.List;

import com.competition.db.pojo.User;
/**
 * 
 * @author 笨蛋
 *@version 1.0
 *@date 2016/5/26
 */
public interface UserService {
		public boolean checkName(String  name);
		public boolean checkPass(String namer,String pass);
		public void addUser(User user);
		public void updateUser(User user);
		public List<User> getAll();
		
}
