package com.competition.db.service;

import java.util.List;

import com.competition.db.pojo.AlbumComment;
import com.competition.db.pojo.UserAlbum;

/**
 * 
 * @author 笨蛋
 *@version 1.0
 */
public interface AlbumCommentService {
public void addCommentByAluObj(UserAlbum album);
	
	//删除评论
	public void deleteCommentByComObj(AlbumComment comment);
	
	//取到所有评论
	public List<AlbumComment> findAllCommentByAluObj(UserAlbum album);
	
	//
	public void updateCommentByAluObj(AlbumComment album);
}
