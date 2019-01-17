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
         return "INSERT INTO u_character_badge (cb_fk_character,cb_fk_badge) VALUES(" + idChar + "," + idBadge +")";
    }
     public Boolean insertBadgeForCharacter(int idBadge,int idChar) throws SQLException {
        ResultSet result;
	result = DbManagement.getInstance().query(addBadgeToChar(idBadge,idChar));
	result.next();
	if(result.isBeforeFirst() || result.isAfterLast()) {
		return false;
	}
           result.close();
           return true;
     }
}
