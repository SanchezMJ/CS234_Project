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
public class Cart {
    private double total;
    //private String seat;
    private ArrayList<Concession> listOfProducts;
    private ArrayList<Seating> seatSelection;
    
    public Cart(){
        this.listOfProducts=new ArrayList<>();
        this.seatSelection=new ArrayList<>();
        this.total = 0.0;
        //this.seat = seat;
        
    }
    
    public Concession getProduct(Concession product){
        return product;
    }
    
    //Method adds a seat and increases total for Cart
    public void addSeat(Seating seat) {
        seatSelection.add(seat);
        total = total + seat.getSeatCost();
    }
    
    public ArrayList<Seating> getSeatSelection() {
        return seatSelection;
    }
    
    public String getSeatId(Object seat) {
        Seating s = new Seating();
        String st;
        st = s.getSeat();
        return st;
    }
    
        //Method adds selected product and increases total for Cart
    public void addProduct(Concession con) {
        listOfProducts.add(con);
        total = total + con.getPrice();
        System.out.println("total: "+total);
    }
    
    public ArrayList<Concession> showProducts(){
        return listOfProducts;
    
    }
 
    public double getTotal() {
        System.out.println("tota: "+total);
        return total;
    }
    
    public void emptyCart(){
        seatSelection.clear();
        listOfProducts.clear();
        total=0;
    }
    
    //Method to print itemized products in cart.  Can add for listOfProducts
    public void getCart() {
        for (Seating a:seatSelection) {
            System.out.println("Seat: " + a.getSeat() + " Price: $" + a.getSeatCost());
        }
    }
    
}
