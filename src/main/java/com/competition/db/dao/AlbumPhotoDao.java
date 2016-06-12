package com.competition.db.dao;

import java.util.List;
import java.util.Set;

import com.competition.db.common.BasicDao;
import com.competition.db.pojo.AlbumPhoto;
import com.competition.db.pojo.UserAlbum;

public interface AlbumPhotoDao extends BasicDao<AlbumPhoto>{
	/**
	 * 
	 * @param album 曾今持久化
	 * @param photo
	 */
	public boolean addPhotoByAluObj(UserAlbum album,AlbumPhoto photo);

	/**
	 * 
	 * @param photo 曾经持久化
	 */
	public boolean deletePhotoByPhtObj(AlbumPhoto photo);
	
	//
	public List<AlbumPhoto> findAllPhotoByAluObj(UserAlbum album);
	
	/**
	 * 
	 * @param album 曾经持久化
	 * @param photo 
	 */
	public boolean updatePhotoByAluObj(UserAlbum album,AlbumPhoto photo);
	
}
