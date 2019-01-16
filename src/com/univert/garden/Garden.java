/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.garden;
import java.util.ArrayList;

/**
 *
 * @author Aurélien
 */
public class Garden {
    int g_id;
    String g_name;
    int g_num_row;
    int g_num_col;
    ArrayList<Slot> g_slot;  
    ArrayList <com.univert.character.Character> g_char;
    
    public Garden(int id,String name,int nb_row,int nb_col,ArrayList<Slot> slot){
        g_id=id;
        g_name=name;
        g_num_row=nb_row;
        g_num_col=nb_col;
        g_slot=slot;
    }
    public Garden(int id,String name,int nb_row,int nb_col,ArrayList<Slot> slot,com.univert.character.Character newCharacter){
        g_id=id;
        g_name=name;
        g_num_row=nb_row;
        g_num_col=nb_col;
        g_slot=slot;
        g_char.add(newCharacter);
    }
    public Garden(int id,String name,int nb_row,int nb_col,ArrayList<Slot> slot,ArrayList<com.univert.character.Character> newCharacters){
        g_id=id;
        g_name=name;
        g_num_row=nb_row;
        g_num_col=nb_col;
        g_slot=slot;
        g_char=newCharacters;
    }
    
    public void addCharacter(com.univert.character.Character newCharacter){
        g_char.add(newCharacter);
    }
}


