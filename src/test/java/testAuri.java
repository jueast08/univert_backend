/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java;
import com.univert.quest.*;
import com.univert.character.*;
import com.univert.garden.*;
import java.util.ArrayList;

/**
 *
 * @author Aurélien
 */
public class testAuri {
    
    
    public static void main(String [] args){
    com.univert.character.Character myChar = new  com.univert.character.Character (1,"Motta");
    Plant myPlant = new Plant(1,"Tomate","myPicture");
    Slot slot11 = new Slot(1,1,1,myPlant);
    Slot slot12 = new Slot(2,1,2,myPlant);
    Slot slot21 = new Slot(3,2,1,myPlant);
    Slot slot22 = new Slot(4,2,2,myPlant);
    ArrayList<Slot> mySlotList = new ArrayList<Slot>(){{
      add(slot11);
      add(slot12);
      add(slot21);
      add(slot22);
    }};
    Garden myGarden = new Garden(1,"myGarden",2,2,mySlotList);
    Quest myQuest = new Quest(1,"myQuest","first Quest",1,1,2,slot11);
    
    //TO DO test
    }
}   
