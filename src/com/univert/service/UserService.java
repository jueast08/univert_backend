package com.univert.service;

import java.sql.SQLException;

import com.univert.dao.UserDao;


public class UserService {
	public static boolean verifyUser(String id, String mdp) throws SQLException {
		if(UserDao.getInstance().getDelegate().getNumUserVerify(id, mdp) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean verifyBadge(String id) throws SQLException {
		if(UserDao.getInstance().getDelegate().getNumBadgeVerify(id) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
}
