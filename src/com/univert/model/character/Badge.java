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
public class Badge {
    int b_id;
    String b_description;
    String b_picture;
    
      public Badge(int id,String description,String picture){
        b_id=id;
        b_description=description;
        b_picture=picture;
    }
      public Badge(){
          
      }
      
      public void setId(int id){
          b_id=id;
      }
      public void setDescription(String desc){
          b_description=desc;
      }
      public void setPicture(String pic){
          b_picture=pic;
      }
}
