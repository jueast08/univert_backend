/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.dao;

/**
 *
 * @author Aurélien
 */
public class ItemDao {
   private static ItemDao instance;
	private DbItemDao delegate;
	 
	public static ItemDao getInstance(){
	    if(instance==null) {
	    	instance= new ItemDao();
	    }
	    return instance;
	}

	public void setDelegate(DbItemDao delegate){
		this.delegate = delegate;
	}
	
	public DbItemDao getDelegate(){
		return delegate;
	}

	public boolean isDelegated(){
		return delegate!=null;
	}
}
