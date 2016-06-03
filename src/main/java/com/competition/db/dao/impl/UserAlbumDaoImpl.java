package com.competition.db.dao.impl;




import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import com.competition.db.common.BasicOperation;
import com.competition.db.dao.UserAlbumDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserAlbum;



public class UserAlbumDaoImpl extends BasicOperation<UserAlbum> implements UserAlbumDao{
	
		@Override
	public void addAlbumByUsrObj(User user, UserAlbum album) {
		// TODO Auto-generated method stub
			album.setM_UAlbum_User(user);
			getSessionFactory().getCurrentSession().save(album);
	}

	@Override
	public void deleteAlbumByAluObj(UserAlbum album) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(album);
		
	}

	@Override
	public UserAlbum findAlbumByDate(Date date) {
		// TODO Auto-generated method stub
		String sqlFind = "select distinct album from Album album";
		UserAlbum album = (UserAlbum)getSessionFactory().getCurrentSession().createQuery(sqlFind+ "where album.createdTime = :date")
				.setString("date", date.toString()).uniqueResult();
			return album;
	}
	/**
	 * 更新用户对此相册的操作
	 */
	@Override
	public void updateAlbumByAluObj(UserAlbum album) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(album);
	}

	/**
	 * 查询一个用户的所用相片
	 */
	@Override
	public List<UserAlbum> getAll(User user) {
		// TODO Auto-generated method stub
		String hqlString = "select userAlbum from UserAlbum as userAlbum where userAlbum.user_id ="
				+ "(select user_id from User where user.user_name = :user_name)";
		List<?> l = getSessionFactory().getCurrentSession().createSQLQuery(hqlString).setString("user_name", user.getM_sUserName()).list();
		List<UserAlbum> albums= new ArrayList<>(); 
		for(Object ele: l){
			UserAlbum album = (UserAlbum)ele;
			albums.add(album);
		}
		return albums;
	}

	/**
	 * 根据User对象找到所有的相册
	 */
	@Override
	public List<UserAlbum> findAlbumsByUsrObj(User user) {
		// TODO Auto-generated method stub
		Set<UserAlbum> userAlbum_set = user.getM_UAAlbums();
		List<UserAlbum>userAlbums = new ArrayList<>();
		for(Object ele: userAlbum_set){
			UserAlbum userAlbum = (UserAlbum)ele;
			userAlbums.add(userAlbum);
		}
		return userAlbums;
	}
}
