package com.competition.db.service.impl;

import java.util.List;

import com.competition.db.dao.UserFollowDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserFollow;
import com.competition.db.service.UserFollowService;

public class UserFollowServiceImpl implements UserFollowService{
	
	private UserFollowDao userFollowDao;

	@Override
	public void addUserFollowByObj(User user, UserFollow userFollow) {
		// TODO Auto-generated method stub
		userFollowDao.addUserFollowByObj(user, userFollow);
		
	}

	@Override
	public void deleteUserFollow(UserFollow userFollow) {
		// TODO Auto-generated method stub
		userFollowDao.deleteUserFollow(userFollow);
	}

	@Override
	public List<UserFollow> getAllUserFollow(User user) {
		// TODO Auto-generated method stub
		return userFollowDao.getUserFollow(user);
	}
}
