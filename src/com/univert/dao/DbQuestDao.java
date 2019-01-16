package com.univert.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.univert.db.DbManagement;
import com.univert.service.StatusService;

public class DbQuestDao {

    public static final String AllQuestQuery = "select * from u_quest";
    
    public static final String NumberQuestQuery = "select count(*) from u_quest";
    
    public static final String AllQuestFilteredQuery = "select * from u_quest INNER JOIN u_status ON u_status.s_id = q_fk_status WHERE u_status =" + StatusService.getOnGoingStatus();
	
	public Integer getNumQuestFinish() throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(NumberQuestQuery);
		result.next();
		return result.getInt(1);
	}
}
