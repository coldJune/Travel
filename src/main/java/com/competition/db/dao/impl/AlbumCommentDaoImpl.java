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

	/*
	 * (non-Javadoc) 参数形式造成了和其他类的形式不统一
	 * @see bbw.dao.AlbumCommentDao#addCommentByAluObj(bbw.dao.pojo.UserAlbum)
	 */
	//👌
	@Override
	public void addCommentByAluObj(UserAlbum album,AlbumComment comment) {
		comment.setM_UA_Comements_UserAlbums(album);
		getSessionFactory().getCurrentSession().save(comment);
	}

	/**
	 * 通过AlbumComment删除评论
	 */
	@Override
	public void deleteCommentByComObj(AlbumComment comment) {
		getSessionFactory().getCurrentSession().delete(comment);
	}

	@Override
	public List<AlbumComment> findAllCommentByAluObj(UserAlbum album) {
		this.getSessionFactory().getCurrentSession().update(album);
		Set<AlbumComment> comments_set = album.getM_UCAlbumComment();
		List<AlbumComment> comments_list = new ArrayList<>();
		for(AlbumComment ele: comments_set){
			comments_list.add(ele);
		}
		return comments_list;
	}

//	@Override
//	public void updateCommentByAluObj(AlbumComment album) {
//		getSessionFactory().getCurrentSession().save(album);
//	}
}
