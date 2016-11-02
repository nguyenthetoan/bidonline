package com.project.bidonline.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.project.bidonline.dao.UserDAO;
import com.project.bidonline.entity.User;
@Transactional
public class UserImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveAccount(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUser(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("username", username));
		return (User) crit.uniqueResult();
	}

}
