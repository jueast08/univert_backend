/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.model.character;

/**
 *
 * @author Aurélien
 */
public class Item {
    int i_id;
    String i_description;
    String i_picture;
    
    public Item(int id,String description,String picture){
        i_id=id;
        i_description=description;
        i_picture=picture;
    }
}
