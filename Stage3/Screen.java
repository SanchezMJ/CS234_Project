/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Michael Sanchez
 */
public class Screen {
    private String name;
    private String type;
    private List<String> seatList;
    private ArrayList <Screen> screens;
    private ArrayList <String> seating;
    
        public Screen(String n, String t) {
        screens = new ArrayList();
        seating = new ArrayList();
        this.seatList = new ArrayList<>();
        name = n;
        type = t;
        if (type == "imax") {
            seatList.addAll(Arrays.asList("IA1, IA2, IA3"));
            seating.addAll(seatList);
            
        }else {
           seatList.addAll(Arrays.asList("RA1, RA2, RA3")); 
           seating.addAll(seatList);
        }
        }
        public Screen(String n) {
        screens = new ArrayList();
        seating = new ArrayList();
        this.seatList = new ArrayList<>();
        name = n;
        type = "Regular";
        seatList.addAll(Arrays.asList("RA1, RA2, RA3")); 
        seating.addAll(seatList);
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Screen> getScreens() {
        return screens;
    }

    public void setScreens(ArrayList<Screen> screens) {
        this.screens = screens;
    }

    //If tp is "imax", assign different seating
    public void setSeating() {
        
        if (type == "imax") {
            seatList.addAll(Arrays.asList("RA1, RA2, RA3"));
            seating.addAll(seatList);
            
        }else {
           seatList.addAll(Arrays.asList("IA1, IA2, IA3")); 
           seating.addAll(seatList);
        }
    }
    
    public ArrayList<String> getSeating() {
        return seating;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + " Type: " + type + "\n" + seating;
    }
}
