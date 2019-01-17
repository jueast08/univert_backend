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
public class BadgeDao {
     private static BadgeDao instance;
	private DbBadgeDao delegate;
	 
	public static BadgeDao getInstance(){
	    if(instance==null) {
	    	instance= new BadgeDao();
	    }
	    return instance;
	}

	public void setDelegate(DbBadgeDao delegate){
		this.delegate = delegate;
	}
	
	public DbBadgeDao getDelegate(){
		return delegate;
	}

	public boolean isDelegated(){
		return delegate!=null;
	}
}
