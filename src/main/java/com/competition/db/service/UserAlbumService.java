package com.competition.db.service;

import java.sql.Date;
import java.util.List;

import com.competition.db.pojo.User;
import com.competition.db.pojo.UserAlbum;
/**
 * 
 * @author 笨蛋
 *@date 2016/5/28
 */
public interface UserAlbumService {
		//添加相册
		public void addAlbumByUsrObj(User user,UserAlbum album);

		//删除相册
		public void deleteAlbumByAluObj(UserAlbum album);
		
		//通过日期查看相册
		public UserAlbum findAlbumByDate(Date date);
		
		//查看用户所有相册
		public List<UserAlbum> findAlbumsByUsrObj(User user);
		
		//获取相册中相片的数量
		public int getPhotoNum(UserAlbum album);
		
		//修改相册
		public void updateAlbumByAluObj(UserAlbum album);
		
		public List<UserAlbum> getAll(User user);
}
