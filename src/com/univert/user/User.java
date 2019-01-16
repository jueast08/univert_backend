/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.user;

/**
 *
 * @author Aurélien
 */
public class User {
    int u_id;
    String u_username;
    String u_password;
    String u_mail;
    com.univert.character.Character u_character;
    
    public User(int id,String username,String password,String mail){
        u_id=id;
         u_username=username;
         u_password=password;
         u_mail=mail;
    }
    public void addCharacter(com.univert.character.Character newChar){
        u_character=newChar;
    }
}
