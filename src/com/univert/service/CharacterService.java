/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.service;

import com.univert.dao.CharacterDao;
import java.sql.SQLException;
import com.univert.model.character.*;

/**
 *
 * @author Aurélien
 */
public class CharacterService {

    public static com.univert.model.character.Character getCharacter(int idUser) throws SQLException {
    	return CharacterDao.getInstance().getDelegate().getCharacterById(idUser);
    }
    
    public static Badge getBadge(int idUser) throws SQLException {
    	return CharacterDao.getInstance().getDelegate().getBadge(idUser);
    }
     
    public static Item getItem(int idUser) throws SQLException {
    	return CharacterDao.getInstance().getDelegate().getItem(idUser);
    }
}
