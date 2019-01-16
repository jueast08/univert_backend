package com.univert.dao;

public class QuestDao {


	private static QuestDao instance;
	private DbQuestDao delegate;
	 
	public static QuestDao getInstance(){
	    if(instance==null) {
	    	instance= new QuestDao();
	    }
	    return instance;
	}

	public void setDelegate(DbQuestDao delegate){
		this.delegate = delegate;
	}
	
	public DbQuestDao getDelegate(){
		return delegate;
	}

	public boolean isDelegated(){
		return delegate!=null;
	}
	
}
