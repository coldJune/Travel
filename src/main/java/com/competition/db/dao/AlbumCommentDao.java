package com.competition.db.dao;



import java.util.List;

import com.competition.db.common.BasicDao;
import com.competition.db.pojo.AlbumComment;
import com.competition.db.pojo.UserAlbum;



public interface AlbumCommentDao extends BasicDao<AlbumComment>{
	
	//
	public void addCommentByAluObj(UserAlbum album);
	
	//
	public void deleteCommentByComObj(AlbumComment comment);
	
	//
	public List<AlbumComment> findAllCommentByAluObj(UserAlbum album);
	
	//
	public void updateCommentByAluObj(AlbumComment album);
}

