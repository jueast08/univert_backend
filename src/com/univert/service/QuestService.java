package com.univert.service;

import java.sql.SQLException;
import java.util.List;

import com.univert.dao.QuestDao;
import com.univert.model.quest.Quest;


public class QuestService {
	
	public static int getNumQuestFinish() throws SQLException {
		return QuestDao.getInstance().getDelegate().getNumQuestFinish();
	}

	public static Quest getQuestById(int id) throws SQLException {
		return QuestDao.getInstance().getDelegate().getQuestById(id);
	}

	public static List<Quest> getQuestsByGarden(String status,int idGarden) throws SQLException {
		return QuestDao.getInstance().getDelegate().getAllQuestsByStatus(status, idGarden);
	}
	
	
	public static boolean setQuestByUser(int idQuest, int idUser) throws SQLException {
	//	boolean statusToUpdate = calcStatusUpdate();
		boolean returnBool = QuestDao.getInstance().getDelegate().setQuestByUser(idQuest, idUser);
/*		if(returnBool && statusToUpdate) {
			QuestDao.getInstance().getDelegate().updateStatus(StatusService.getOnGoingStatus())
		}*/
		
		return returnBool;
	}
}
