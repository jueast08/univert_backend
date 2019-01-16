/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.service;

import com.univert.dao.CharacterDao;
import java.sql.SQLException;

/**
 *
 * @author Aurélien
 */
public class CharacterService {
    public static int getCharacterInfo(int idUser) throws SQLException {
    	Integer id = CharacterDao.getInstance().getDelegate().getCharacter(idUser);
    	if(id != null) {
    		return id;
    	}
		return 0;
	}
    
     public static int getBadgeInfo(int idCharacter) throws SQLException {
    	Integer id =  CharacterDao.getInstance().getDelegate().getBadge(idCharacter);
		if(id != null) {
    		return id;
    	}
		return 0;
	}
     
      public static int getItemInfo(int idCharacter) throws SQLException {
    	Integer id =  CharacterDao.getInstance().getDelegate().getItem(idCharacter);
		if(id != null) {
    		return id;
    	}
		return 0;
	}
}
