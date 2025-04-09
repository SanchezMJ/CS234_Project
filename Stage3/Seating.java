/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

/**
 *
 * @author mjsanchez
 */
public class Seating {
    private String seat;
    private double seatCost;
    private String type;
    
    public Seating() {
        seat = seat;
        type = type;
        seatCost = 11.5;
        if (type == "imax") {
            this.seatCost = 20.0;
        } else {
            this.seatCost = 11.50;
        }   
    }
    
    public Seating(String s, String t) {
        seat = s;
        type = t;
        seatCost = 11.5;
        if (type == "imax") {
            this.seatCost = 20.0;
        } else {
            this.seatCost = 11.50;
        }   
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

    
    public void remScreenSeats(String rem) {
        //seatSelection
    }
    
    public void addScreenSeats() {
        
    }
    
    
}
