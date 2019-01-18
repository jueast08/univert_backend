package com.univert.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagement implements IDbManagement {

    private static DbManagement instance;
    private ADbManagement delegate;

    private DbManagement(){
    }

    public static DbManagement getInstance(){
        if(instance == null)
        {
            instance = new DbManagement();
        }
        return instance;
    }

    public DbManagement(ADbManagement delegate)
    {
        this.delegate = delegate;
    }

    public void setDelegate(ADbManagement delegate)
    {
        this.delegate = delegate;
    }

    public boolean isDelegated(){
        return !(delegate == null);
    }


    @Override
    public void connection(String bdd_path) throws SQLException {
        delegate.connection(bdd_path);
    }

    @Override
    public void logOut() throws SQLException {
        delegate.logOut();
    }

    @Override
    public ResultSet query(String query_string) throws SQLException {
        return delegate.query(query_string);
    }

	@Override
	public int insert(String insert_string) throws SQLException {
		return delegate.insert(insert_string);
	}

	@Override
	public Statement getStatement() throws SQLException {
		return delegate.getStatement();
	}
}
