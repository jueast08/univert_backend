/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.dao;

import com.univert.db.DbManagement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.univert.model.character.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aurélien
 */
public class DbCharacterDao {
      
    
    public static final String getCharacterSql(int idUser) {
            return "select c_name from u_character INNER JOIN u_user_character ON c_id=uc_fk_character RIGHT JOIN u_user ON uc_fk_user = u_id where u_id="+idUser;
    }
        
    public static final String getAllBadgeSql(int idUser) {
            return "select * from u_badge INNER JOIN u_character_badge ON b_id=cb_badge LEFT JOIN u_character ON cb_fk_character=c_id INNER JOIN u_user_character ON uc_fk_character=c_id LEFT JOIN u_user ON uc_fk_user= u_id WHERE u_id=" + idUser;
    }

     public static final String getAllItemSql(int idUser) {
            return "select * from u_item INNER JOIN u_character_item ON i_id=ci_item LEFT JOIN u_character ci_fk_character=c_id INNER JOIN u_user_character ON uc_fk_character=c_id LEFT JOIN u_user ON uc_fk_user=u_id=" + idUser;
    } 
     public static final String getOneBadgeSql(int idBadge) {
            return "select * from u_badge WHERE b_id="  + idBadge;
    }

     public static final String getOneItemSql(int idItem) {
           return "select * from u_item WHERE i_id="  + idItem;
     } 
     
     
    public com.univert.model.character.Character getCharacterById(int idUser) throws SQLException {
                com.univert.model.character.Character charById = new com.univert.model.character.Character(); 
        
		ResultSet result;
		result = DbManagement.getInstance().query(getCharacterSql(idUser));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return null;
		}
                //changer les "1"
                charById.setId(result.getInt(1));
                charById.setName(result.getString(2));
                charById.setExperience(result.getInt(3));
                charById.setLevel(result.getInt(4));
                
                result.close();
                return charById;
	}
    public Badge getBadge(int idBadge) throws SQLException {
                Badge badge = new Badge();
                
		ResultSet result;
		result = DbManagement.getInstance().query(getOneBadgeSql(idBadge));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return null;
		}
                // changer les "1"
                badge.setId(result.getInt(1));
                badge.setDescription(result.getString(2));
                badge.setPicture(result.getString(3));
                result.close();
                
		return badge;
	}
     public Item getItem(int idItem) throws SQLException {
                Item item = new Item();
                
		ResultSet result;
		result = DbManagement.getInstance().query(getOneItemSql(idItem));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return null;
		}
                // changer les "1"
                item.setId(result.getInt(1));
                item.setDescription(result.getString(2));
                item.setPicture(result.getString(3));
                result.close();
                
		return item;
     }
     
     public List<Badge> getAllBadgeByUser(int idUser) throws SQLException {
		List<Badge> listReturn = new LinkedList<Badge>();
		ResultSet result;
		result = DbManagement.getInstance().query(getAllBadgeSql(idUser));
		result.next();
		while(!result.isBeforeFirst() && !result.isAfterLast()) {
			listReturn.add(getBadge(result.getInt(1)));
			result.next();
		}
		return listReturn;
	}
     
     public List<Item> getAllItemByUser(int idUser) throws SQLException {
		List<Item> listReturn = new LinkedList<Item>();
		ResultSet result;
		result = DbManagement.getInstance().query(getAllItemSql(idUser));
		result.next();
		while(!result.isBeforeFirst() && !result.isAfterLast()) {
			listReturn.add(getItem(result.getInt(1)));
			result.next();
		}
		return listReturn;
	}
}
