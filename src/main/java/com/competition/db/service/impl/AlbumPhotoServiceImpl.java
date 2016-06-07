package com.competition.db.service.impl;

import java.io.File;
import java.util.List;

import com.competition.db.dao.AlbumPhotoDao;
import com.competition.db.pojo.AlbumPhoto;
import com.competition.db.pojo.UserAlbum;
import com.competition.db.service.AlbumPhotoService;

public class AlbumPhotoServiceImpl implements AlbumPhotoService {
	
	private AlbumPhotoDao albumPhotoDao;
	
	public void setAlbumPhotoDao(AlbumPhotoDao albumPhotoDao) {
		this.albumPhotoDao = albumPhotoDao;
	}

	@Override
	public void addPhotoByAluObj(UserAlbum album, AlbumPhoto photo) {
		// TODO Auto-generated method stub
		albumPhotoDao.addPhotoByAluObj(album, photo);
	}

	@Override
	public void deletePhotoByPhtObj(AlbumPhoto photo) {
		// TODO Auto-generated method stub
		albumPhotoDao.deletePhotoByPhtObj(photo);
	}

	@Override
	public List<AlbumPhoto> findAllPhotoByAluObj(UserAlbum album) {
		// TODO Auto-generated method stub
		return albumPhotoDao.findAllPhotoByAluObj(album);
	}

	@Override
	public void updatePhotoByAluObj(UserAlbum album, AlbumPhoto photo) {
		// TODO Auto-generated method stub
		albumPhotoDao.updatePhotoByAluObj(album, photo);
	}

	@Override
	public String savePhoto(UserAlbum album, AlbumPhoto photo, File file) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
