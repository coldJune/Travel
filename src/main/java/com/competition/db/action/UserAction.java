package com.competition.db.action;

import com.competition.db.pojo.User;
import com.competition.db.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 关于用户操作的action
 * @author 笨蛋
 *
 */
public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9175766057987372213L;
	private User user;
	private UserService us;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}
/**
 * 登录的方法
 * @return String usermain 表明登录成功跳转到用户主界面
 * @return String login 返回登录界面
 */
	public  String login() throws Exception{
			if(us.checkPass(user.getM_sUserName(), user.getM_sUserPass())){
				ActionContext.getContext().getSession().put("useinfo", user);
				return "usermain";
			}
			return	 LOGIN;
		}
	/**
	 * 更新用户信息
	 * @return String userInfo 修改后跳转到用户信息界面 
	 * @throws Exception
	 */
	public String update() throws Exception{
		us.updateUser(user);
		return "userinfo";
	}
	
	//public String regist() throws Exception{
		
	//}
}
