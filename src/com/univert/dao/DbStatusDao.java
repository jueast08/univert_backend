package com.univert.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.univert.db.DbManagement;


public class DbStatusDao {
    private static final String getStatusIdByDescriptionQuery(String status) {
    	return "SELECT s_id FROM `u_status` WHERE s_description = '" + status + "'";
    }
    
	public Integer getStatusIdByDescription(String status) throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(getStatusIdByDescriptionQuery(status));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return null;
		}
		return result.getInt(1);
	}
    
}