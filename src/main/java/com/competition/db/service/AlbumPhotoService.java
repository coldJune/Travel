package com.competition.db.service;

import java.io.File;
import java.util.List;

import com.competition.db.pojo.AlbumPhoto;
import com.competition.db.pojo.UserAlbum;
/**
 * 
 * @author 笨蛋
 *@date 2016/5/28
 */
public interface AlbumPhotoService {
	//添加照片
	public void addPhotoByAluObj(UserAlbum album,AlbumPhoto photo);
	
	/**
	 * 
	 * @param album
	 * @param photo
	 * @param file	将要保存的上传文件域
	 * @return
	 */
	public String savePhoto(UserAlbum album, AlbumPhoto photo,File file);

	//删除照片
	public void deletePhotoByPhtObj(AlbumPhoto photo);
	
	//获得所有照片
	public List<AlbumPhoto> findAllPhotoByAluObj(UserAlbum album);
	
	//更新相册中照片
	public void updatePhotoByAluObj(UserAlbum album,AlbumPhoto photo);
}
