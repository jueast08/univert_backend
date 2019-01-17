/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.dao;

import com.univert.db.DbManagement;
import com.univert.model.character.Item;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aurélien
 */
public class DbItemDao {
    public static final String addItemToChar(int idItem,int idChar) {
         return "INSERT INTO u_character_item (ci_fk_character,ci_fk_item) VALUES('" + idChar + ",'" + idItem +")";
    }
    public static final String findItemByIdQuest(int idQuest) {
         return "SELECT * FROM u_item INNER JOIN u_item_loot ON i_id=u_fk_item INNER JOIN u_loot_package ON u_fk_loot_package=lp_id INNER JOIN u_quest ON lp_id=q_id WHERE q_id=" + idQuest;
    }
    public static final String findCharFromUser(int idUser){
        return "select * from u_character INNER JOIN u_user_character ON c_id=uc_fk_character RIGHT JOIN u_user ON uc_fk_user = u_id where u_id="+idUser;
    }

    
    public Item getItemByIdQuest(int idQuest) throws SQLException {
        Item item = new Item(); 
        
	ResultSet result;
	result = DbManagement.getInstance().query(findItemByIdQuest(idQuest));
	result.next();
	if(result.isBeforeFirst() || result.isAfterLast()) {
		return null;
	}
        item.setId(result.getInt(1));
        item.setDescription(result.getString(2));
        item.setPicture(result.getString(3));
        
        result.close();
        return item;
	}
    
     public Boolean insertItemForCharacter(int idItem,int idChar) throws SQLException {
        ResultSet result;
	result = DbManagement.getInstance().query(addItemToChar(idItem,idChar));
	result.next();
	if(result.isBeforeFirst() || result.isAfterLast()) {
		return false;
	}
           result.close();
           return true;
	}
     
      public int setCharIdFromUser(int idUser) throws SQLException {
        com.univert.model.character.Character charById = new com.univert.model.character.Character(); 
        ResultSet result;
	result = DbManagement.getInstance().query(findCharFromUser(idUser));
	result.next();
	if(result.isBeforeFirst() || result.isAfterLast()) {
		return 0;
	}
        charById.setId(result.getInt(1));
        result.close();
        return charById.getId();
	}
}
