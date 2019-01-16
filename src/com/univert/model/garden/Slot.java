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
public class Slot {
    int s_id;
    int s_row_position;
    int s_col_position;
    Plant s_plant;
    
    public Slot(int id,int row,int col,Plant plant){
        s_id=id;
        s_row_position=row;
        s_col_position=col;
        s_plant=plant;
    }
}
