package com.univert.service;

import com.univert.dao.DbItemDao;
import com.univert.dao.ItemDao;
import com.univert.model.character.Item;
import java.sql.SQLException;

public class ItemService {
	public static Boolean earnItem(int idQuete, int idChar) throws SQLException {
            Item test = ItemDao.getInstance().getDelegate().getItemByIdQuest(idQuete);
            if(test !=null) {
            	return ItemDao.getInstance().getDelegate().insertItemForCharacter(test.getId(),idChar);
            } else {
            	return false;
            }
	}       
}
