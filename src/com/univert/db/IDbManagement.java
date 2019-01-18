package com.univert.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface IDbManagement {
	
	/**
	 * This Function established a connection with a BDD using MySQL driver
	 * @Function connection
	 * @param String bdd_path : the location of the BDD  
	 * @throws SQLException : to catch all SQL issue
	 */
    public void connection(String bdd_path) throws SQLException;
    
    /**
     * This Function disconnect the connection with the current BDD
	 * @Function connection
     */
    public void logOut() throws  SQLException;
    
    /**
     * This Function is used to send a querry to the BDD (non update BDD)
     * @Function query 
     * @param String query_string : SQL Querry
     * @return ResultSet : results of the querry
     * @throws SQLException : to catch all SQL issue
     */
    public ResultSet query(String query_string) throws SQLException;
    
    /**
     * This Function is used to send a querry to the BDD (update BDD) 
     * @Function insert 
     * @param String insert_string : SQL Querry
     * @return int : results of the querry
     * @throws SQLException : to catch all SQL issue
     */
    public int insert(String insert_string) throws SQLException;
    
    /**
     * This Function is used to send a querry to the BDD (update BDD) 
     * @Function insert 
     * @param String insert_string : SQL Querry
     * @return int : results of the querry
     * @throws SQLException : to catch all SQL issue
     */
    public Statement getStatement() throws SQLException;

}

