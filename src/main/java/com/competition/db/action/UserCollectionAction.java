package com.competition.db.action;

import com.competition.db.pojo.User;
import com.competition.db.pojo.UserCollection;
import com.competition.db.service.UserCollectionService;
import com.opensymphony.xwork2.ActionSupport;

public class UserCollectionAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4630711805066118789L;
	private UserCollectionService ucs;
	private User user;
	private UserCollection collection;
	private static final String USERCOLLECTION="usercollection";
	public UserCollectionService getUcs() {
		return ucs;
	}
	public void setUcs(UserCollectionService ucs) {
		this.ucs = ucs;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	public UserCollection getCollection() {
		return collection;
	}
	public void setCollection(UserCollection collection) {
		this.collection = collection;
	}
	/**
	 * 添加收藏相册
	 * @return	usercollection 跳转相册收藏界面
	 * @throws Exception
	 */
	public String addCollection()throws Exception{
		ucs.addCollectionByColObj(collection, user);
		return USERCOLLECTION;
	}
	/**
	 * 删除收藏相册
	 * @return usercollection 跳转相册收藏界面
	 * @throws Exception
	 */
	public String deleteCollection()throws Exception{
		ucs.deleteCollectionByColObj(collection);
		return USERCOLLECTION;
	}
	
	public String findAll()throws Exception{
		ucs.findAllCollectionByUsrObj(user);
		return USERCOLLECTION;
	}
}
