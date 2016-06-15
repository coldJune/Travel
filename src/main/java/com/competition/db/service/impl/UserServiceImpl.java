package com.competition.db.service.impl;

import java.util.Date;
import java.util.List;

import javax.management.ServiceNotFoundException;

import com.competition.db.dao.UserDao;
import com.competition.db.mailutil.MD5Util;
import com.competition.db.mailutil.SendMail;
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
		System.out.println(name);
		User user = userDao.findUserByName(name);
		
		if(user!=null){
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
	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		String email=user.getM_sUserName();
		System.out.println(user);
		System.out.println(email);
		user.setRegisterTime(new Date());
		user.setM_bIsMailActivate(false);
		user.setValidateCode(MD5Util.encode2hex(email));
		this.addUser(user);
		
		StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！<br>");
        sb.append("http://localhost:8080/springmvc/user/register?action=activate&email="); 
        sb.append(email);
        sb.append("&validateCode=");
        sb.append(user.getValidateCode());
        sb.append("");
        
        SendMail.send(email, sb.toString());
	}
	@Override
	public void activate(String email, String validateCode) throws ServiceNotFoundException {
		// TODO Auto-generated method stub
		User user =userDao.findUserByName(email);
		if(user!=null){
			if(!user.getM_bIsMailActivate()){
				Date currentTime = new Date();
				currentTime.before(user.getRegisterTime());
				if(currentTime.before(user.getLastActivateTime())){
					if(validateCode.equals(user.getValidateCode())){
						user.setM_bIsMailActivate(true);
						this.updateUser(user);;
					}else{
						throw new ServiceNotFoundException("激活码不正确");
					}
				}else {
					throw new ServiceNotFoundException("激活码已过期");
				}
			}else{
				throw  new ServiceNotFoundException("邮箱已激活，请登录");
			}
		}else{
			throw new ServiceNotFoundException("该邮箱未注册");
		}
	}
}


