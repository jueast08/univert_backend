package com.univert.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.univert.db.DbManagement;
import com.univert.model.quest.Quest;
import com.univert.service.StatusService;

public class DbQuestDao {

    private static final String AllQuestQuery = "select * from u_quest";
    
    private static final String NumberQuestQuery = "select count(*) from u_quest";
    
    private static final String AllQuestFilteredQuery = "select * from u_quest INNER JOIN u_status ON u_status.s_id = q_fk_status WHERE u_status =" + StatusService.getOnGoingStatus();

    private static final String ResetQuestsStatusQuery = "UPDATE `u_quest` SET `q_fk_status`= 4";
    private static final String ResetQuestsCharQuery = "delete from  `u_character_quest`";
    
    private static final String setStatusQuestQuery(int idQuest, int idStatus) {
    	return "UPDATE `u_quest` SET `q_fk_status`= " + idStatus + " WHERE q_id =" + idQuest;
    }
    
    private static final String getOneQuestQuery(int id) {
    	return "select * from u_quest left join u_type ON q_fk_type = t_id WHERE q_id =" + id;
    }
    
    private static final String getExperienByQuestQuery(int id) {
    	return "select q_experience FROM u_quest where q_id = " +id;
    }
    
    private static final String getCharacterByUserId(int id) {
    	return "select * FROM u_user_character where uc_fk_user = " +id;
    }
    
    private static final String getNumCharacterOnQuestQuery(int id) {
    	return "select COUNT(*) from u_character_quest inner join u_quest ON cq_fk_quest = q_id  WHERE q_id =" + id;
    }
    
    private static final String getAllQuestsByStatusQuery(String status, int id) {
    	return "select q_id from u_quest inner join u_status ON q_fk_status = u_status.s_id  inner join u_slot ON u_slot.s_id = q_fk_slot inner join u_garden ON g_id = s_fk_garden  WHERE s_description ='" + status + "' AND g_id =" + id;
    }
    
    private static final String getAllQuestsByStatusUserQuery(String status, int id) {
    	return "select q_id from u_quest inner join u_status ON q_fk_status = u_status.s_id  inner join u_character_quest ON cq_fk_quest = q_id inner join u_character ON u_character.c_id = cq_fk_character inner join u_user_character ON uc_fk_character = u_character.c_id inner join u_user ON u_user.u_id = u_user_character.uc_fk_user WHERE s_description ='" + status + "' AND u_id =" + id;
    }
    
    private static final String insertUserQuest(int idQuest, int idCharacter) {
    	return "insert into u_character_quest VALUES (null," + idCharacter + "," + idQuest + ")" ;
    }
    
    private static final String getCharacterIdByQuestQuery(int idQuest) {
    	return "select cq_fk_character FROM u_character_quest WHERE cq_fk_quest =" + idQuest;
    }
    
    
	
    public boolean resetQuests() throws SQLException {
		return DbManagement.getInstance().insert(ResetQuestsStatusQuery) >= 1 && DbManagement.getInstance().insert(ResetQuestsCharQuery) >= 1;	
    }
    
	public Integer getNumQuestFinish() throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(NumberQuestQuery);
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return null;
		}
		return result.getInt(1);
	}

	public Quest getQuestById(int id) throws SQLException {
		Quest quest = new Quest();
		
		ResultSet result;
		result = DbManagement.getInstance().query(getOneQuestQuery(id));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return null;
		}
		quest.setId(result.getInt(1));
		quest.setDescription(result.getString(3));
		quest.setExperience(result.getInt(8));
		quest.setMaxCharacter(result.getInt(7));
		quest.setMinCharacter(result.getInt(6));
		quest.setTitle(result.getString(2));
		quest.setType(result.getString(16));
		result.close();
		
		result = DbManagement.getInstance().query(getNumCharacterOnQuestQuery(id));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			quest.setNbCharacter(0);
		} else {
			quest.setNbCharacter(result.getInt(1));
		}
		result.close();
		
		return quest;
	}

	public List<Quest> getAllQuestsByStatus(String status, int idGarden) throws SQLException {
		List<Quest> listReturn = new LinkedList<Quest>();
		ResultSet result;
		result = DbManagement.getInstance().query(getAllQuestsByStatusQuery(status, idGarden));
		result.next();
		while(!result.isBeforeFirst() && !result.isAfterLast()) {
			listReturn.add(getQuestById(result.getInt(1)));
			result.next();
		}
		return listReturn;
	}
	
	public List<Quest> getAllQuestsByStatusUser(String status, int idUser) throws SQLException {
		List<Quest> listReturn = new LinkedList<Quest>();
		ResultSet result;
		result = DbManagement.getInstance().query(getAllQuestsByStatusUserQuery(status, idUser));
		result.next();
		while(!result.isBeforeFirst() && !result.isAfterLast()) {
			listReturn.add(getQuestById(result.getInt(1)));
			result.next();
		}
		return listReturn;
	}
	
	public boolean setQuestByUser(int idQuest, int idUser) throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(getCharacterByUserId(idUser));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return false;
		}
		int idCharacter = result.getInt(3);
		int resultInt = DbManagement.getInstance().insert(insertUserQuest(idQuest, idCharacter));
		if(resultInt == 0) {
			return false;
		}
		return true;	
	}

	public boolean setQuestDone(int idQuest) throws SQLException {
		ResultSet result;
		Integer idStatus = StatusDao.getInstance().getDelegate().getStatusIdByDescription(StatusService.getClosedStatus());
		if(idStatus == null) {
			return false;
		}
		int resultInt = DbManagement.getInstance().insert(setStatusQuestQuery(idQuest, idStatus.intValue()));
		if(resultInt == 0) {
			return false;
		}
		return true;
	}
	
	public boolean setQuestInProgress(int idQuest) throws SQLException {
		Integer idStatus = StatusDao.getInstance().getDelegate().getStatusIdByDescription(StatusService.getOnGoingStatus());
		if(idStatus == null) {
			return false;
		}
		int resultInt = DbManagement.getInstance().insert(setStatusQuestQuery(idQuest, idStatus.intValue()));
		if(resultInt == 0) {
			return false;
		}
		return true;
	}
	
	public int getExperienByQuest(int id) throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(getExperienByQuestQuery(id));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return 0;
		}
		return result.getInt(1);
    }
	
	public List<Integer> getCharacterIdByQuest(int idQuest) throws SQLException {
		List<Integer> listReturn = new LinkedList<Integer>();
		ResultSet result;
		result = DbManagement.getInstance().query(getCharacterIdByQuestQuery(idQuest));
		result.next();
		while(!result.isBeforeFirst() && !result.isAfterLast()) {
			listReturn.add(result.getInt(1));
			result.next();
		}
		return listReturn;
    }
}
