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
}
