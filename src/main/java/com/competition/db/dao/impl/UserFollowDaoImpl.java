package com.competition.db.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.competition.db.common.BasicOperation;
import com.competition.db.dao.UserFollowDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserFollow;

public class UserFollowDaoImpl extends BasicOperation<User> implements UserFollowDao {

	@Override
	public void addUserFollowByObj(User user, UserFollow userFollow) {
		// TODO Auto-generated method stub
		userFollow.setM_UUser(user);
		getSessionFactory().getCurrentSession().save(userFollow);
	}

	@Override
	public void deleteUserFollow(UserFollow userFollow) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(userFollow);
		
	}

	@Override
	public List<UserFollow> getUserFollow(User user) {
//		// TODO Auto-generated method stub
//		String sqlAll = "select distinct userFollow from UserFollow as userFollow where user.m_UUser=?0";
////		List<UserFollow> l = getSessionFactory().getCurrentSession().createQuery(sqlAll).list();
//		
//		List<UserFollow> l = find(sqlAll,user.get)
//		List<UserFollow> userFollows = new ArrayList<>();
//		for(UserFollow uf: l){
//			userFollows.add(uf);
//		}
//		return userFollows;
		
		Set<UserFollow> userFollows_set = user.getM_UFUserFollow();
		List<UserFollow> userFollows_list = new ArrayList<>();
		for(UserFollow uf: userFollows_set){
			userFollows_list.add(uf);
		}
		return userFollows_list;
	}
}
