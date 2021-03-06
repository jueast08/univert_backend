package com.univert.init;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.univert.dao.DbQuestDao;
import com.univert.dao.DbStatusDao;
import com.univert.dao.DbUserDao;
import com.univert.dao.DbCharacterDao;
import com.univert.dao.QuestDao;
import com.univert.dao.StatusDao;
import com.univert.dao.UserDao;
import com.univert.dao.BadgeDao;
import com.univert.dao.CharacterDao;
import com.univert.dao.DbBadgeDao;
import com.univert.dao.DbItemDao;
import com.univert.dao.ItemDao;
import com.univert.db.DbManagement;
import com.univert.db.MySQLManagement;

import java.sql.SQLException;

public class ServletContextClass implements ServletContextListener {

    DbManagement SQLManager;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
         try {
            Class.forName("org.mariadb.jdbc.Driver");
            
        } catch (Exception e)
        {
            System.err.println("Impossible de charger le driver " + e.getMessage ());
            System.exit (1); 
        }
       
        SQLManager = DbManagement.getInstance();
        SQLManager.setDelegate(new MySQLManagement());
        
        try {
        	SQLManager.connection("jdbc:mariadb://localhost/univert");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        QuestDao.getInstance().setDelegate(new DbQuestDao());
        UserDao.getInstance().setDelegate(new DbUserDao());
        CharacterDao.getInstance().setDelegate(new DbCharacterDao());
        ItemDao.getInstance().setDelegate(new DbItemDao());
        StatusDao.getInstance().setDelegate(new DbStatusDao());
        BadgeDao.getInstance().setDelegate(new DbBadgeDao());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
        	SQLManager.logOut();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}