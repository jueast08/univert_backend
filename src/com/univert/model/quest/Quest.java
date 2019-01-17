/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.model.quest;
//import com.wavemaker.runtime.data.annotations.ColumnAlias;

/**
 *
 * @author Aurélien
 */
public class Quest {

	int id;
    String title;
    String description;
    int minCharacter;
    int maxCharacter;
    int nbCharacter;
    int experience;
    String type;
  
    public Quest(){
    }
    
    public Quest(int id, String title, String description, int minCharacter, int maxCharacter, int nbCharacter, int experience, String type){
    	this.id = id;
    	this.title = title;
    	this.description = description;
        this.minCharacter = minCharacter;
        this.maxCharacter = maxCharacter;
        this.nbCharacter = nbCharacter;
        this.experience = experience;
        this.type = type;
    }
    
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMinCharacter() {
		return minCharacter;
	}

	public void setMinCharacter(int minCharacter) {
		this.minCharacter = minCharacter;
	}

	public int getMaxCharacter() {
		return maxCharacter;
	}

	public void setMaxCharacter(int maxCharacter) {
		this.maxCharacter = maxCharacter;
	}

	public int getNbCharacter() {
		return nbCharacter;
	}

	public void setNbCharacter(int nbCharacter) {
		this.nbCharacter = nbCharacter;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    
    
    /*
    public Quest(int id,String title,String description,int min,int max,int xp,int loot,Slot slot){
        q_title=title;
        q_description=description;
        q_min_character=min;
        q_max_character=max;
        q_experience=xp;
        q_loot_package=loot;
        q_slot=slot;
        q_status=4;// open
    }
    
     public Quest(int id,String title,String description,int min,int max,int xp,Slot slot){
        q_id=id;
        q_title=title;
        q_description=description;
        q_min_character=min;
        q_max_character=max;
        q_experience=xp;
        q_slot=slot;
        q_status=4;// open
     }
        
    public Quest(int id,String title,String description,int min,int max,int xp,int loot,Slot slot,int create){
        q_id=id;
        q_title=title;
        q_description=description;
        q_min_character=min;
        q_max_character=max;
        q_experience=xp;
        q_loot_package=loot;
        q_slot=slot;
        q_create_by_id_character=create;
        q_status=4;//  open
    } 
      public Quest(int id,String title,String description,int min,int max,int xp,Slot slot,int create){
        q_id=id;
        q_title=title;
        q_description=description;
        q_min_character=min;
        q_max_character=max;
        q_experience=xp;
        q_slot=slot;
        q_create_by_id_character=create;
        q_status=4;//  open
    }*/
}