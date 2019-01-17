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
public class DbBadgeDao {
    public static final String addBadgeToChar(int idBadge,int idChar) {
         return "INSERT INTO u_character_badge  VALUES(null," + idChar + "," + idBadge +")";
    }
    
     public Boolean insertBadgeForCharacter(int idBadge,int idChar) throws SQLException {
		int result = DbManagement.getInstance().insert(addBadgeToChar(idBadge,idChar));
		if(result == 0) {
			return false;
		} else {
			return true;
		}
     }
}
