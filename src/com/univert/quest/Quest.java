/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.quest;
import com.univert.garden.Slot;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aurélien
 */
public class Quest {
    int q_id;
    String q_title;
    String q_description;
    Date q_start;
    Date q_end;
    int q_min_character;
    int q_max_character;
    int q_experience;
    int q_create_by_id_character;
    int q_loot_package;
    int q_status;
    Slot q_slot;   

    public Quest(int id,String title,String description,int min,int max,int xp,int loot,Slot slot){
        q_id=id;
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
    }
}