/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

/**
 *
 * @author jbock
 */
public class Showtimes {
    private String title;
    private int time;
    private int screen;
    
    public Showtimes(String title, int time, int screen){
    this.title=title;
    this.time=time;
    this.screen=screen;
}
    
    public void setTitle(String Title){
        this.title=Title;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTime(int Time){
        this.time=Time;
    }
    
    public int getTime(){
        return time;
    }
    
    public void displayTimes(){
        
    }
}
