/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

//import cs234project.Cart;
import java.util.ArrayList;

/**
 *
 * @author jbock
 */
public class Showtimes {
    private Movie title;
    private int time;
    private Screen screen;
    
    public Showtimes(){
    this.title = new Movie("Unknown", "0m", "NR", "No description");
    this.time = 0;
    this.screen = new Screen("Unknown Screen");
}
    public Showtimes(Movie title, int time, Screen screen){
    this.title=title;
    this.time=time;
    this.screen=screen;
}
    
    public void setTitle(Movie title){
        this.title=title;
    }
    
    public String getTitle(){
        return title.getMovieTitle();
    }
    
    public void setTime(int time){
        this.time=time;
    }
    
    public int getTime(){
        return time;
    }
    
    public Screen getScreen() {
        return screen;
    }
    public String getScreenType() {
        return screen.getType();
    }
    
    public ArrayList<String> getShowSeating() {
        return screen.getSeating();
    }
    
    public void displayShowSeating() {
        screen.displaySeating(screen);
    }
    
    /**
     * Method takes the arraylist of selected seats and replaces those
     * values with a "xxx" designation so users know they are taken and cant
     * request the same seat values.
     * @param cart uses object cart
     * @param show modifies the unique show object seating list.
     */
    public void seatsTaken (Cart cart, Showtimes show) {
        ArrayList<Seating>list = new ArrayList<>();
        ArrayList<String>seating = new ArrayList<>();
        list = cart.getSeatSelection();
        String current;
        seating = show.getShowSeating();
        for (Seating t:list) {
            current = t.getSeat();
            //System.out.println(current);
            for (int i = 0; i < seating.size(); i++) {
                if(seating.get(i).equals(current)) {
                    seating.set(i, "XXX");
                    break;
                }
            }
        }
    }
        
    @Override
    public String toString(){
        return "Title: " + title.getMovieTitle() +
       "\nTime: " + time +
       "\nScreen: " + screen.getName(); // if getName() exists
    }
    
}
