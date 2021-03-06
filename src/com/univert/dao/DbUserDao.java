package com.univert.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.univert.db.DbManagement;

public class DbUserDao {
    public static final String getUserQuery = "select * from u_user";
	
    public static final String getUserQuery(String id, String mdp) {
    	return "select *  from u_user where u_username ='" + id + "'AND u_password ='"  + mdp +"'";
    }
    
    public static final String getBadgeQuery(String id) {
    	return "select * from u_user where u_badgeId ='" + id +"'";
    }
    
    public Integer getIdUserVerify(String id, String mdp) throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(getUserQuery(id, mdp));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return null;
		}
		return result.getInt(1);
	}
    
    public Integer getIdBadgeVerify(String id) throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(getBadgeQuery(id));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return null;
		}
		return result.getInt(1);
	}
}
