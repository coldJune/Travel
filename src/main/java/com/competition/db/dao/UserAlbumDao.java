package com.competition.db.dao;


import java.util.Date;
import java.util.List;

import com.competition.db.common.BasicDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserAlbum;

public interface UserAlbumDao extends BasicDao<UserAlbum>{
	//增
	public void addAlbumByUsrObj(User user,UserAlbum album);

	//删
	public void deleteAlbumByAluObj(UserAlbum album);
	
	//查
	public List<UserAlbum> findAlbumByDate(Date date);
	/**
	 * 查询Album中的Photo数量
	 * @param album
	 * @return
	 */
	public int findNumOfAlbumPhoto(UserAlbum album);
	
//	/**
//	 * 查找符合条件的多个用户的相册记录
//	 * @param Id	多个用户的用户名
//	 * @return 返回查找到的所有记录
//	 */
//	public List<UserAlbum> findAlbumByUserId(String Id[]);
//		
	//改
	public void updateAlbumByAluObj(UserAlbum album);
	
	public List<UserAlbum> getAll(User user);
}
