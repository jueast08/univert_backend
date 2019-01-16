package com.univert.init;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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