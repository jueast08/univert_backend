package com.univert.service;

import java.sql.SQLException;

import com.univert.dao.QuestDao;


public class QuestService {
	
	public static int getNumQuestFinish() throws SQLException {
		return QuestDao.getInstance().getDelegate().getNumQuestFinish();
	}

}
