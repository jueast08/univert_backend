
package com.univert.dao;


public class StatusDao {


	private static StatusDao instance;
	private DbStatusDao delegate;
	 
	public static StatusDao getInstance(){
	    if(instance==null) {
	    	instance= new StatusDao();
	    }
	    return instance;
	}

	public void setDelegate(DbStatusDao delegate){
		this.delegate = delegate;
	}
	
	public DbStatusDao getDelegate(){
		return delegate;
	}

	public boolean isDelegated(){
		return delegate!=null;
	}
	
}
