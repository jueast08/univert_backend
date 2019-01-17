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
    int id;
    String description;
    String picture;
    
    public Item(int id,String description,String picture){
        this.id=id;
        this.description=description;
        this.picture=picture;
    }
    public Item(){
        
    }
    public void setId(int id){
          this.id=id;
    }
    public void setDescription(String desc){
          description=desc;
    }
    public void setPicture(String pic){
          picture=pic;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }
}
