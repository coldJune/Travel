package com.competition.db.dao;

import java.util.List;

import com.competition.db.common.BasicDao;
import com.competition.db.pojo.AlbumComment;
import com.competition.db.pojo.UserAlbum;



public interface AlbumCommentDao extends BasicDao<AlbumComment>{
	
	/**
	 * 应用场景：当用户新添加一天评论时......
	 * @param album必须曾经持久化
	 */
	public boolean addCommentByAluObj(UserAlbum album,AlbumComment comment);
	
	/**
	 * 
	 * @param comment必须曾经持久化
	 */
	public boolean deleteCommentByComObj(AlbumComment comment);
	
	/**
	 * 
	 * @param album必须曾经持久化
	 * @return
	 */
	public List<AlbumComment> findAllCommentByAluObj(UserAlbum album);
	
	/**
	 * 通过添加删除可以完成功能
	 * @param album必须曾经持久化
	 */
//	public void updateCommentByAluObj(AlbumComment album);
}
