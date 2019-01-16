/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.dao;

import com.univert.db.DbManagement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aurélien
 */
public class DbCharacterDao {
      
    
   
            
    public static final String getCharacterInfo(int idUser) {
            return "select * from u_character INNER JOIN u_user_character ON c_id=uc_fk_character INNER JOIN u_user ON uc_fk_user =" + idUser;
    }
        
    public static final String getBadgeInfo(int idUser) {
            return "select * from u_badge INNER JOIN u_character_badge ON b_id=cb_badge INNER JOIN u_character ON cb_fk_character=c_id INNER JOIN u_user_character ON uc_fk_character=c_id INNER JOIN u_user ON uc_fk_user=" + idUser;
    }
    
     public static final String getItemInfo(int idUser) {
            return "select * from u_item INNER JOIN u_character_item ON i_id=ci_item INNER JOIN u_character ci_fk_character=c_id INNER JOIN u_user_character ON uc_fk_character=c_id INNER JOIN u_user ON uc_fk_user=" + idUser;
    } 
     
    public Integer getCharacter(int idUser) throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(getCharacterInfo(idUser));
		result.next();
		return result.getInt(1);
	}
    public Integer getBadge(int idUser) throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(getBadgeInfo(idUser));
		result.next();
		return result.getInt(1);
	}
     public Integer getItem(int idUser) throws SQLException {
		ResultSet result;
		result = DbManagement.getInstance().query(getItemInfo(idUser));
		result.next();
		return result.getInt(1);
	}
            
     
     
}
