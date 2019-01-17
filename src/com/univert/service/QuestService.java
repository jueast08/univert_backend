package com.univert.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.univert.dao.CharacterDao;
import com.univert.dao.QuestDao;
import com.univert.model.character.CharacterXp;
import com.univert.model.quest.Quest;


public class QuestService {
	static int idBadge = 2;
	
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
		boolean returnBool = QuestDao.getInstance().getDelegate().setQuestByUser(idQuest, idUser);
		if(returnBool) {
			QuestDao.getInstance().getDelegate().setQuestInProgress(idQuest);
		}
		return returnBool;
	}

	public static boolean setQuestDone(int idQuest) throws SQLException {
		boolean returnBool = QuestDao.getInstance().getDelegate().setQuestDone(idQuest);	
		int expQuest = QuestDao.getInstance().getDelegate().getExperienByQuest(idQuest);
		List<Integer> listChara = QuestDao.getInstance().getDelegate().getCharacterIdByQuest(idQuest);
		for(Integer oneChara : listChara) {
			int xpAfter;
			int levelAfter;
			CharacterXp caraXp = CharacterDao.getInstance().getDelegate().getCharaExp(oneChara);
			ItemService.earnItem(idQuest, oneChara);
			int xpBefore = caraXp.getXp() + expQuest;
			if(xpBefore >= 1000) {
				if(idBadge > 5) {
					idBadge = 2;
				}
				xpAfter = xpBefore - 1000;
				levelAfter = caraXp.getLevel() + 1;
				BadgeService.earnBadge(idBadge, oneChara);
				idBadge++;
			} else {
				xpAfter = xpBefore;
				levelAfter = caraXp.getLevel();
			}
			CharacterDao.getInstance().getDelegate().setExp(xpAfter, oneChara, levelAfter);
		}
		return returnBool;
	}

	public static List<Quest> getQuestsByUser(String status,int idUser) throws SQLException {
		return QuestDao.getInstance().getDelegate().getAllQuestsByStatusUser(status, idUser);
	}
	
	
}
