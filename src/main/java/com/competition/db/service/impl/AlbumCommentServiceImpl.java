package com.competition.db.service.impl;

import java.util.List;

import com.competition.db.dao.AlbumCommentDao;
import com.competition.db.pojo.AlbumComment;
import com.competition.db.pojo.UserAlbum;
import com.competition.db.service.AlbumCommentService;

public class AlbumCommentServiceImpl implements AlbumCommentService {
	private AlbumCommentDao  albumCommentDao;
	
	public void setAlbumCommentDao(AlbumCommentDao albumCommentDao) {
		this.albumCommentDao = albumCommentDao;
	}

	@Override
	public void addCommentByAluObj(UserAlbum album) {
		// TODO Auto-generated method stub
		albumCommentDao.addCommentByAluObj(album);
	}

	@Override
	public void deleteCommentByComObj(AlbumComment comment) {
		// TODO Auto-generated method stub
		albumCommentDao.delete(comment);
	}

	@Override
	public List<AlbumComment> findAllCommentByAluObj(UserAlbum album) {
		// TODO Auto-generated method stub
		return albumCommentDao.findAllCommentByAluObj(album);
	}

	@Override
	public void updateCommentByAluObj(AlbumComment album) {
		// TODO Auto-generated method stub

	}

}
