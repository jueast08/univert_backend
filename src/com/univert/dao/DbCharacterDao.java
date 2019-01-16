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

/**
 *
 * @author Aurélien
 */
public class DbCharacterDao {
      
    
    public static final String getCharacterSql(int idUser) {
            return "select c_name from u_character RIGHT JOIN u_user_character ON c_id=uc_fk_character RIGHT JOIN u_user ON uc_fk_user = u_id where u_id="+idUser;
    }
        
    public static final String getBadgeSql(int idUser) {
            return "select * from u_badge RIGHT JOIN u_character_badge ON b_id=cb_badge RIGHT JOIN u_character ON cb_fk_character=c_id RIGHT JOIN u_user_character ON uc_fk_character=c_id RIGHT JOIN u_user ON uc_fk_user= u_id WHERE u_id=" + idUser;
    }

     public static final String getItemSql(int idUser) {
            return "select * from u_item RIGHT JOIN u_character_item ON i_id=ci_item RIGHT JOIN u_character ci_fk_character=c_id RIGHT JOIN u_user_character ON uc_fk_character=c_id RIGHT JOIN u_user ON uc_fk_user=u_id=" + idUser;
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
                charById.setLevel(result.getInt(1));
                charById.setExperience(result.getInt(1));
                charById.setName(result.getString(1));
                result.close();
                return charById;
	}
    public Badge getBadge(int idUser) throws SQLException {
                Badge badge = new Badge();
                
		ResultSet result;
		result = DbManagement.getInstance().query(getBadgeSql(idUser));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return null;
		}
                // changer les "1"
                badge.setId(result.getInt(1));
                badge.setDescription(result.getString(1));
                badge.setPicture(result.getString(1));
                result.close();
                
		return badge;
	}
     public Integer getItem(int idUser) throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(getItemSql(idUser));
		result.next();
		if(result.isBeforeFirst() || result.isAfterLast()) {
			return null;
		}
		return result.getInt(1);
	}
            
     
     
}
