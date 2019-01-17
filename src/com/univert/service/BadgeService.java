/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.service;

import com.univert.dao.BadgeDao;
import java.sql.SQLException;

/**
 *
 * @author Aurélien
 */
public class BadgeService {
    public static Boolean earnBadge(int idQuete, int idChar) throws SQLException {
        return BadgeDao.getInstance().getDelegate().insertBadgeForCharacter(idQuete,idChar);
    }
}
