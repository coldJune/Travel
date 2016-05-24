package com.competition.db.userbackground.dao;



import java.util.List;

import com.competition.db.common.BasicDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserBackground;


public interface UserBackgroundDao extends BasicDao<UserBackground>{
	//增
	public void addBackgroundByUsrObj(User user,UserBackground background);
	
	//删
	public void deleteBackgroundByBakObj(UserBackground background);
	
	//查
	public List<UserBackground> findAllBackgroundByUsrObj(User user);
	
	//改
}

