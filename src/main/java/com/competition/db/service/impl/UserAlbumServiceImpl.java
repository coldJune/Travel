package com.competition.db.service.impl;

import java.sql.Date;
import java.util.List;

import com.competition.db.dao.UserAlbumDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserAlbum;
import com.competition.db.service.UserAlbumService;

public class UserAlbumServiceImpl implements UserAlbumService {
	private UserAlbumDao userAlbumDao ;
	public void setUserAlbumDao(UserAlbumDao userAlbumDao) {
		this.userAlbumDao = userAlbumDao;
	}

	@Override
	public void addAlbumByUsrObj(User user, UserAlbum album) {
		// TODO Auto-generated method stub
		userAlbumDao.addAlbumByUsrObj(user, album);
	}

	@Override
	public void deleteAlbumByAluObj(UserAlbum album) {
		// TODO Auto-generated method stub
		userAlbumDao.deleteAlbumByAluObj(album);
	}

	@Override
	public UserAlbum findAlbumByDate(Date date) {
		// TODO Auto-generated method stub
		return userAlbumDao.findAlbumByDate(date);
	}

	@Override
	public List<UserAlbum> findAlbumsByUsrObj(User user) {
		// TODO Auto-generated method stub
		return userAlbumDao.findAlbumsByUsrObj(user);
	}

	@Override
	public void updateAlbumByAluObj(UserAlbum album) {
		// TODO Auto-generated method stub
		userAlbumDao.updateAlbumByAluObj(album);
	}

	@Override
	public List<UserAlbum> getAll(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
