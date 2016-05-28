package com.competition.db.service;

import java.util.List;

import com.competition.db.pojo.User;
import com.competition.db.pojo.UserCollection;
/**
 * 
 * @author 笨蛋
 *@date 2016/5/28
 */
public interface UserCollectionService {
	//增加收藏
		public void addCollectionByColObj(UserCollection collection,User user);
		
		//删除收藏
		public void deleteCollectionByColObj(UserCollection collection);
		
		//查看收藏
		public List<UserCollection> findAllCollectionByUsrObj(User user);
		
		//修改收藏
		public void updateCollectionByColObj(UserCollection collection);
		
}
