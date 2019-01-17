/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.model.character;

import java.util.ArrayList;

import com.univert.model.quest.Quest;

/**
 *
 * @author Aurélien
 */
public class Character {
    int c_id;
    String c_name;
    int c_experience;
    int c_level;
    String c_picture; 
    ArrayList<Item> c_character_item;
    ArrayList<Badge> c_character_badge;
    ArrayList<Quest> c_character_questFinish;
    ArrayList<Quest> c_character_questOnGoing;
    
    
    public Character(){
        
    }
    public Character(int id,String name){
        c_id=id;
        c_name=name;
        c_level=1;
        c_experience = 0;
    }

    public void gainXP(int xp){
        c_experience += xp;
        if(c_experience >= 5){
            c_level+=1;
        }
    }
    
    public void gainItem(Item newItem){
        c_character_item.add(newItem);
    }
    public void gainBadge(Badge newBadge){
        c_character_badge.add(newBadge);
    }
     
    public void chooseQuest(Quest quest){
        c_character_questOnGoing.add(quest);
        
     }
    public void validQuest(Quest quest){
         if(c_character_questOnGoing.remove(quest)){
             c_character_questFinish.add(quest);
         }
         else{
             System.err.println("Attentino la quete n'est pas en cours, elle ne peut etre validée");
        }
     }
    public void setId(int id){
         c_id=id;
    }
    public void setName(String name){
         c_name=name;
    }
    public void setExperience(int xp){
         c_experience=xp;
    }
    public void setLevel(int level){
         c_level=level;
    }
    public int getId(){
         return c_id;
    }
    public String getName(){
         return c_name;
    }
    public int getExperience(){
         return c_experience;
    }
    public int getLevel(){
         return c_level;
    }
}