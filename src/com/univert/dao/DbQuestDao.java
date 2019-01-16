package com.univert.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.univert.db.DbManagement;
import com.univert.service.StatusService;

public class DbQuestDao {

	  
    public static final String AllQuestQuery = "select * from u_quest";
    public static final String NumberQuestQuery = "select count(*) from u_quest";
    public static final String AllQuestFilteredQuery = "select * from u_quest INNER JOIN u_status ON u_status.s_id = q_fk_status WHERE u_status =" + StatusService.getOnGoingStatus();
    
    
    public static final String CountPairTypeByPlatformQuery(String Platform) {
    	return "select count(*) as count from "+Platform+"";
    }
    
    public static final String PairNameByPlatformQuery(String Platform) {
    	return "select * from "+Platform+"";	
    }
	
	/*
	public ResultSet getAllQuest(boolean open) throws SQLException {

	}*/
	
	public Integer getNumQuestFinish() throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(NumberQuestQuery);
		if(!result.next()){
            return result.getInt(1);
        }
        else{
        	result.beforeFirst();
        }
		return result.getInt(1);
	}
}
