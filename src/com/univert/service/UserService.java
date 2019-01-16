package com.univert.service;

import java.sql.SQLException;

import com.univert.dao.UserDao;


public class UserService {
	public static int verifyUser(String id, String mdp) throws SQLException {
		Integer idReturn = UserDao.getInstance().getDelegate().getIdUserVerify(id, mdp);
		if(idReturn != null) {
			return idReturn.intValue();
		}
		return 0;
	}
	
	public static int verifyBadge(String id) throws SQLException {
		Integer idReturn = UserDao.getInstance().getDelegate().getIdBadgeVerify(id);
		if(idReturn != null) {
			return idReturn.intValue();
		}
		return 0;
	}
}
