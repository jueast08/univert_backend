package com.univert.dao;


public class UserDao {


	private static UserDao instance;
	private DbUserDao delegate;
	 
	public static UserDao getInstance(){
	    if(instance==null) {
	    	instance= new UserDao();
	    }
	    return instance;
	}

	public void setDelegate(DbUserDao delegate){
		this.delegate = delegate;
	}
	
	public DbUserDao getDelegate(){
		return delegate;
	}

	public boolean isDelegated(){
		return delegate!=null;
	}
	
}
