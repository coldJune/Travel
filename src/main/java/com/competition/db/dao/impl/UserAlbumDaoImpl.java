package com.competition.db.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.competition.db.common.BasicOperation;
import com.competition.db.dao.UserAlbumDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserAlbum;

public class UserAlbumDaoImpl extends BasicOperation<UserAlbum> implements UserAlbumDao{
	@Override
	public void addAlbumByUsrObj(User user, UserAlbum album) {
			album.setM_UAlbum_User(user);
			getSessionFactory().getCurrentSession().save(album);
	}
	@Override
	public void deleteAlbumByAluObj(UserAlbum album) {
		getSessionFactory().getCurrentSession().delete(album);
	}
	@Override	
	@SuppressWarnings("unchecked")
	public List<UserAlbum> findAlbumByDate(Date date) {		
		String sqlFind = "select distinct album from UserAlbum album";
		
		List<UserAlbum> albums = (List<UserAlbum>)getSessionFactory().getCurrentSession().createQuery(sqlFind + " where album.m_DAlbumCreatedTime = :date")
				.setString("date", date.toString()).list();
		return albums;
	}
	/**
	 * 更新用户对此相册的操作
	 */
	@Override
	public void updateAlbumByAluObj(UserAlbum album) {
		getSessionFactory().getCurrentSession().update(album);
	}

	/**
	 * 查询一个用户的所用相片
	 */
	@Override
	public List<UserAlbum> getAll(User user) {
		this.getSessionFactory().getCurrentSession().update(user);
		Set<UserAlbum> albums_set = user.getM_UAAlbums();
		List<UserAlbum> albums_list = new ArrayList<UserAlbum>();
		for(UserAlbum album:albums_set){
			albums_list.add(album);
		}
		return albums_list;
	}

	@Override
	public int findNumOfAlbumPhoto(UserAlbum album) {
		// TODO Auto-generated method stub
		return album.getM_iPhotoNum();
	}

	/**
	 * 根据User对象找到所有的相册
	 * 
	 * 与getAll功能重合
	 */
//	@Override
//	public List<UserAlbum> findAlbumsByUsrObj(User user) {
//		// TODO Auto-generated method stub
//		Set<UserAlbum> userAlbum_set = user.getM_UAAlbums();
//		List<UserAlbum>userAlbums = new ArrayList<>();
//		for(Object ele: userAlbum_set){
//			UserAlbum userAlbum = (UserAlbum)ele;
//			userAlbums.add(userAlbum);
//		}
//		return userAlbums;
//	}
}
