/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.service;

import com.univert.dao.CharacterDao;
import java.sql.SQLException;
import com.univert.model.character.*;
import java.util.List;

/**
 *
 * @author Aurélien
 */
public class CharacterService {

    public static com.univert.model.character.Character getCharacter(int idUser) throws SQLException {
    	return CharacterDao.getInstance().getDelegate().getCharacterById(idUser);
    }
    
    public static List<Badge> getBadge(int idUser) throws SQLException {
    	return CharacterDao.getInstance().getDelegate().getAllBadgeByUser(idUser);
    }
     
    public static List<Item> getItem(int idUser) throws SQLException {
    	return CharacterDao.getInstance().getDelegate().getAllItemByUser(idUser);
    }
}
