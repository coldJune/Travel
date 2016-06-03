package com.competition.db.action;

import com.competition.db.dao.UserBackgroundDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserBackground;
import com.opensymphony.xwork2.ActionSupport;

public class UserBackgroundAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7017622158096327347L;
	private User user;
	private UserBackgroundDao ubd;

	private static final String BACKGROUND="background";
	private UserBackground background;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserBackgroundDao getUbd() {
		return ubd;
	}
	public void setUbd(UserBackgroundDao ubd) {
		this.ubd = ubd;
	}
	public void setBackground(UserBackground background) {
		this.background = background;
	}

	
	
}
