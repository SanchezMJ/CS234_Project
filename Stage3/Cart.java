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
    //sets instance variables
    private double total;
    private ArrayList<Concession> listOfProducts;
    private ArrayList<Seating> seatSelection;

    //constructor initializes product list, seat selection, and total.
    public Cart(){
        this.listOfProducts=new ArrayList<>();
        this.seatSelection=new ArrayList<>();
        this.total = 0.0;
    }

    //gets product from concession class.
    public Concession getProduct(Concession product){
        return product;
    }
    
    //Method adds a seat and increases total for Cart
    public void addSeat(Seating seat) {
        seatSelection.add(seat);
        total = total + seat.getSeatCost();
    }

    //gets seat selection from seating Array List.
    public ArrayList<Seating> getSeatSelection() {
        return seatSelection;
    }

    //gets seat Id
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
    }

    //show concession list of products.
    public ArrayList<Concession> showProducts(){
        return listOfProducts;
    
    }

    //gets the total
    public double getTotal() {
        return total;
    }

    //sets the total
    public void setTotal(double m) {
        total = m;
    }

    //emptys cart after payment
    public void emptyCart(){
        seatSelection.clear();
        listOfProducts.clear();
        total=0;
    }
    
    //Method to print itemized products in cart.  Can add for listOfProducts
    public void getCart() {
        System.out.println();
        if(seatSelection.isEmpty()){
            
        }else {
            for (Seating a:seatSelection) {
            System.out.printf("Seat: " + a.getSeat() + " Price: $%.2f\n", a.getSeatCost());
            }
        }
        if(listOfProducts.isEmpty()) {
            
        }else {
             for (Concession c:listOfProducts) {
                System.out.printf(c.getProduct() + " Price: $%.2f\n",  c.getPrice());   
                }
        }
    }
    
}
