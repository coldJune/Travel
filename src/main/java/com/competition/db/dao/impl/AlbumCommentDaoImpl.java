package com.competition.db.dao.impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.competition.db.common.BasicOperation;
import com.competition.db.dao.AlbumCommentDao;
import com.competition.db.pojo.AlbumComment;
import com.competition.db.pojo.UserAlbum;



public class AlbumCommentDaoImpl extends BasicOperation<AlbumComment> implements AlbumCommentDao{

	/**
	 * 通过UserAlbum对象添加评论
	 */
	@Override
	public void addCommentByAluObj(UserAlbum album) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(album);
	}

	/**
	 * 通过AlbumComment删除评论
	 */
	@Override
	public void deleteCommentByComObj(AlbumComment comment) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(comment);
	}

	@Override
	public List<AlbumComment> findAllCommentByAluObj(UserAlbum album) {
		// TODO Auto-generated method stub
		Set<AlbumComment> comments_set = album.getM_UCAlbumComment();
		List<AlbumComment> comments_list = new ArrayList<>();
		for(AlbumComment ele: comments_set){
			comments_list.add(ele);
		}
		return comments_list;
	}

	@Override
	public void updateCommentByAluObj(AlbumComment album) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(album);
	}
}

