package com.univert.db;

import java.sql.*;


public class MySQLManagement extends ADbManagement {
	
	Connection conn;
	Statement statement;
	
	public void connection(String bdd_path) throws SQLException {
		final String User = "root";
		final String Password = "root";
		try {
			conn = DriverManager.getConnection(bdd_path, User, Password);
			if (conn == null) {
				System.err.println("Could not connect !!");
			}
		statement = conn.createStatement();
		} catch (SQLException e)
		{
			System.err.println("Erreur de connexion " + e.getMessage ()) ;
	    }
	}
	
	public void logOut() throws SQLException {
        if ( statement != null ) {
             try {
                statement.close();
            } catch ( SQLException ignore ) {
            }

        }
        if ( conn != null ) {
            try {
                conn.close();
            } catch ( SQLException ignore ) {
            }
        }
    }
	
    public ResultSet query(String query_string) throws SQLException {
        return statement.executeQuery(query_string);
    }
    
    public int insert(String insert_string)throws SQLException{
    	return statement.executeUpdate(insert_string);
    }
    
    public Statement getStatement() throws SQLException{
    	return statement;
    }
}
