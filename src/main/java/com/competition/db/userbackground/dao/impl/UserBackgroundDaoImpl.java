package com.competition.db.userbackground.dao.impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.competition.db.common.BasicOperation;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserBackground;
import com.competition.db.userbackground.dao.UserBackgroundDao;



public class UserBackgroundDaoImpl extends BasicOperation<UserBackground> implements UserBackgroundDao{
	
	@Override
	public void addBackgroundByUsrObj(User user,UserBackground background) {
		// TODO Auto-generated method stub
		background.setM_UUser(user);
		getSessionFactory().getCurrentSession().save(background);
	}
	
	@Override
		public void deleteBackgroundByBakObj(UserBackground background) {
			// TODO Auto-generated method stub
			getSessionFactory().getCurrentSession().delete(background);
		}

	@Override
	public List<UserBackground> findAllBackgroundByUsrObj(User user) {
		// TODO Auto-generated method stub
		Set<UserBackground> backgrounds_set = user.getM_UBUserBackgrounds();
		List<UserBackground> backgrounds_list = new ArrayList<UserBackground>();
		for(UserBackground ele: backgrounds_set){
			backgrounds_list.add(ele);
		}
		return backgrounds_list;
	}
	

}
