/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.character;

import java.util.ArrayList;
import com.univert.quest.*;

/**
 *
 * @author Aur�lien
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
             System.err.println("Attentino la quete n'est pas en cours, elle ne peut etre valid�e");
        }
     }
}