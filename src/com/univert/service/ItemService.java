package com.univert.service;

import com.univert.dao.DbItemDao;
import com.univert.dao.ItemDao;
import com.univert.model.character.Item;
import java.sql.SQLException;

public class ItemService {
	public static Boolean earnItem(int idQuete, int idUser) throws SQLException {
            Item test = ItemDao.getInstance().getDelegate().getItemByIdQuest(idQuete);
            int idChar = ItemDao.getInstance().getDelegate().setCharIdFromUser(idUser);
            return ItemDao.getInstance().getDelegate().insertItemForCharacter(test.getId(),idChar);
	}       
}
