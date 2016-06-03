package com.competition.db.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.competition.db.common.BasicOperation;
import com.competition.db.dao.UserBackgroundDao;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserBackground;



public class UserBackgroundDaoImpl extends BasicOperation<UserBackground> implements UserBackgroundDao{
	
	@Override
	public void addBackgroundByUsrObj(User user,UserBackground background) {
		background.setM_UUser(user);
		getSessionFactory().getCurrentSession().save(background);
	}
	
	@Override
		public void deleteBackgroundByBakObj(UserBackground background) {
			getSessionFactory().getCurrentSession().delete(background);
		}

	@Override
	public List<UserBackground> findAllBackgroundByUsrObj(User user) {
		this.getSessionFactory().openSession().update(user);
		Set<UserBackground> backgrounds_set = user.getM_UBUserBackgrounds();
		List<UserBackground> backgrounds_list = new ArrayList<UserBackground>();
		for(UserBackground ele: backgrounds_set){
			backgrounds_list.add(ele);
		}
		return backgrounds_list;
	}
	

}
