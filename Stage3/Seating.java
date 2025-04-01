/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import java.util.ArrayList;

/**
 *
 * @author mjsanchez
 */
public class Seating {
    private String seat;
    private double seatCost;
    private String type;
    //private List<String> seatList;
    private ArrayList <String> seatSelection;
    private ArrayList <Screen> seating;
    
    public Seating(String s, String t) {
        seat = s;
        type = t;
        seatCost = 11.5;
        this.seatSelection = new ArrayList();
        this.seating = new ArrayList();
        if (type == "imax") {
            this.seatCost = 20.0;
        } else {
            this.seatCost = 11.50;
        }
        //this.seatList = new ArrayList<>();
        
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public double getSeatCost() {
        return seatCost;
    }

    public void setSeatCost(double seatCost) {
        this.seatCost = seatCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addSeatSelection(String s) {
        seatSelection.add(s);
    }
    
    public void remSeatSelection(String s) {
        seatSelection.remove(s);
    }
    
    public ArrayList<String> getSeatSelection() {
        return seatSelection;
    }
    
    public void remScreenSeats() {
        
    }
    
    public void addScreenSeats() {
        
    }
    
    @Override
    public String toString() {
        return "Current seat selection(s): " + seatSelection;
    }
    
    
}
