/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.model.garden;

/**
 *
 * @author Aurélien
 */
public class Plant {
    int p_id;
    String p_description;
    String p_picture;
    
    public Plant(int id,String description,String picture){
        p_id=id;
        p_description=description;
        p_picture=picture;
    }
}
