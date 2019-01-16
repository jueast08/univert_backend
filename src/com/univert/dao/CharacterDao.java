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
public class CharacterDao {
    private static CharacterDao instance;
	private DbCharacterDao delegate;
	 
	public static CharacterDao getInstance(){
	    if(instance==null) {
	    	instance= new CharacterDao();
	    }
	    return instance;
	}

	public void setDelegate(DbCharacterDao delegate){
		this.delegate = delegate;
	}
	
	public DbCharacterDao getDelegate(){
		return delegate;
	}

	public boolean isDelegated(){
		return delegate!=null;
	}
}
