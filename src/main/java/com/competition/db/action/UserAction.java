package com.competition.db.action;

import java.util.HashMap;
import java.util.Map;

import javax.management.ServiceNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.competition.db.pojo.User;
import com.competition.db.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
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
	private String loginresult;
	private String validateC;
	private String registResult;
	public String getValidateC() {
		return validateC;
	}

	public void setValidateC(String validateC) {
		this.validateC = validateC;
	}

	public String getRegistResult() {
		return registResult;
	}

	public void setRegistResult(String registResult) {
		this.registResult = registResult;
	}
	private static Map<String, Object> map = new HashMap<String,Object>();
	public String getvalidateC() {
		return validateC;
	}

	public void setvalidateC(String validateC) {
		this.validateC = validateC;
	}

	public String getLoginresult() {
	return loginresult;
}

public void setLoginresult(String loginresult) {
	this.loginresult = loginresult;
}

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
				map.put("status", 2);
			}else{
				map.put("status", "1");
			}	
		JSONObject json = JSONObject.fromObject(map);
		loginresult=json.toString();
		return LOGIN;
		
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
	/**
	 * 
	 * @return fail 表示注册失败
	 * @return register 注册成功 跳转
	 * @throws Exception
	 */
	public String regist() throws Exception{
		String validateCode = ServletActionContext.getRequest().getParameter("validateCode");
		if(us.checkName(user.getM_sUserName())){
			if(validateCode.equals(map.get("registerValCode"))){
				us.register(user);
				return "registe";
			}else{
				map.put("validateStatus",1);
			}
		}else{
			map.put("registStatus", 1);
		}
		JSONObject json = JSONObject.fromObject(map);
		registResult =json.toString();
		return "fail";
	}
	public String activate() throws ServiceNotFoundException{
		
		String email =ServletActionContext.getRequest().getParameter("email");
		String validateCode=ServletActionContext.getRequest().getParameter("validateCode");
		us.activate(email, validateCode);
		return LOGIN;
	}
	/**
	 * 验证码产生
	 * @return
	 */
	private String validateRegister(){
		 String validateCode = Integer.toString((int)Math.random()*10000);
		  map = new HashMap<String,Object>();
		 map.put("registerValCode", validateCode);
		 JSONObject json =JSONObject.fromObject(map);
		 validateC = json.toString();
		 return SUCCESS;
	}
}
