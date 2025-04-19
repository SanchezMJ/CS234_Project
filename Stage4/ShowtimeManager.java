/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

import java.util.ArrayList;

/**
 *
 * @author jbock
 */
//Manages Show Times
public class ShowtimeManager {
    private ArrayList<Showtimes>listOfTime;
    
    //constructor
    public ShowtimeManager(){
        this.listOfTime=new ArrayList<>(); 
}
    //adds show time
    public void addShowTime(Showtimes newshowtime){
        listOfTime.add(newshowtime);
    }
    
    //removes show time if it exists
    public void removeShowTime(String title){
        Showtimes toBeRemoved=findShow(title);
        if(toBeRemoved!=null){
            listOfTime.remove(toBeRemoved);
            System.out.println("Show time for "+title+" has been removed.");
        }else{
            System.out.println("Unable to remove.");
        }
    }
    //sets list of show times
    public void setListOfTime(ArrayList<Showtimes> listOfTime){
        this.listOfTime=listOfTime;
    }
    
    //gets list of showtimes
    public ArrayList<Showtimes> getListOfTime(){
        return listOfTime;
    }
    
    //displays showtimes
    public void displayShowTimes(){
        if(listOfTime.isEmpty()){
            System.out.println("List of movies is empty.");
        }else{
        for (Showtimes showtime : listOfTime){
            System.out.println(showtime);
        }
      }   
    }
    
    //searches for show times by title if it exists
    public Showtimes findShow(String title){
        for(Showtimes showtime: listOfTime){
            if(showtime.getTitle().equalsIgnoreCase(title)){
                return showtime;
         }
        }
        System.out.println("Film not found");
        return null;      
     }
}
    