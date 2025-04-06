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
    private Screen screen;
    
    public Showtimes(String title, int time, Screen screen){
    this.title=title;
    this.time=time;
    this.screen=screen;
}
    
    public void setTitle(String title){
        this.title=title;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTime(int time){
        this.time=time;
    }
    
    public int getTime(){
        return time;
    }
    
    public Screen getScreen(){
        return screen;
    }
    
    public void setScreen(Screen screen){
        this.screen=screen;
    }
    
    @Override
    public String toString(){
        return "Title: "+title+" Time: "+time+" Screen: "+screen;
    }
    
}
