package com.competition.db.service;

import java.util.List;

import com.competition.db.pojo.User;
import com.competition.db.pojo.UserFollow;

public interface UserFollowService {
	/**
	 * 根据user和userFollow对象添加用户关注
	 * @param user 此对象必须曾经持久化
	 * @param userFollow	新创建的对象
	 */
	public void addUserFollowByObj(User user, UserFollow userFollow);
	/**
	 * 根据userFollow对象删除记录
	 * @param userFollow 此对象必须曾经持久化
	 */
	public void deleteUserFollow(UserFollow userFollow);
	/**
	 * 得到某一个用户关注的所有的用户
	 * @param user	此对象必须持久化 因为必须具有id属性
	 * @return 返回所有的用户信息
	 */
	public List<UserFollow> getAllUserFollow(User user);
	
}
