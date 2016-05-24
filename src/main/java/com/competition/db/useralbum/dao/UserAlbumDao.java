package com.competition.db.useralbum.dao;



import java.sql.Date;
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
	public UserAlbum findAlbumByDate(Date date);
	public List<UserAlbum> findAlbumsByUsrObj(User user);
	
	//改
	public void updateAlbumByAluObj(UserAlbum album);
	
	public List<UserAlbum> getAll(User user);
}
