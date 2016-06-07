package com.competition.db.action;

import com.competition.db.pojo.User;
import com.competition.db.pojo.UserAlbum;
import com.competition.db.service.UserAlbumService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAlbumAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9131009632870656629L;
	
	private User user;				//User从哪里来的？
	
	private UserAlbum album;
	
	private UserAlbumService uas;
	
	private static  final String USERALBUM="useralbum";
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserAlbum getAlbum() {
		return album;
	}


	public void setAlbum(UserAlbum album) {
		this.album = album;
	}


	public UserAlbumService getUas() {
		return uas;
	}


	public void setUas(UserAlbumService uas) {
		this.uas = uas;
	}

	/**
	 * 添加相册
	 * @return	useralbum  跳转到相册界面
	 * @throws Exception
	 */
	public String addUserAlbum()throws Exception{
		uas.addAlbumByUsrObj(user, album);
		return USERALBUM;
	}
	/**
	 * 删除相册
	 * @return useralbum 跳转到相册界面
	 * @throws Exception
	 */
	public String deleteUserAblum()throws Exception{
		uas.deleteAlbumByAluObj(album);
		return USERALBUM;
	}
	/**
	 * 查找用户所有相册
	 * @return	userablbum 跳转到相册界面
	 * @throws Exception
	 */
	public String findAll()throws Exception{
		uas.findAlbumsByUsrObj(user);
		return USERALBUM;
	}
}
