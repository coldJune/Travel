package com.competition.db.service;

import java.util.List;

import com.competition.db.pojo.User;
import com.competition.db.pojo.UserBackground;

public interface UserBackgroundService {
	//增加背景图片
		public void addBackgroundByUsrObj(User user,UserBackground background);
		
		//删除背景图片
		public void deleteBackgroundByBakObj(UserBackground background);
		
		//查看背景图片
		public List<UserBackground> findAllBackgroundByUsrObj(User user);
}
