package com.competition.db.dao;



import java.util.List;

import com.competition.db.common.BasicDao;
import com.competition.db.pojo.AlbumPhoto;
import com.competition.db.pojo.UserAlbum;


public interface AlbumPhotoDao extends BasicDao<AlbumPhoto>{
	//
	public void addPhotoByAluObj(UserAlbum album,AlbumPhoto photo);

	//
	public void deletePhotoByPhtObj(AlbumPhoto photo);
	
	//
	public List<AlbumPhoto> findAllPhotoByAluObj(UserAlbum album);
	
	//
	public void updatePhotoByAluObj(UserAlbum album,AlbumPhoto photo);
	
}

