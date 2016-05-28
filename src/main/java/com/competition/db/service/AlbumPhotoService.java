package com.competition.db.service;

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

	//删除照片
	public void deletePhotoByPhtObj(AlbumPhoto photo);
	
	//获得所有照片
	public List<AlbumPhoto> findAllPhotoByAluObj(UserAlbum album);
	
	//更新相册中照片
	public void updatePhotoByAluObj(UserAlbum album,AlbumPhoto photo);
}
