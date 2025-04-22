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
    private ArrayList<Concession> listOfProducts;
    private ArrayList<Seating> seatSelection;
    
    public Cart(){
        this.listOfProducts=new ArrayList<>();
        this.seatSelection=new ArrayList<>();
        this.total = 0.0;
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
    }
    
    public ArrayList<Concession> showProducts(){
        return listOfProducts;
    
    }
 
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double m) {
        total = m;
    }
    public void emptyCart(){
        seatSelection.clear();
        listOfProducts.clear();
        total=0;
    }
    public String getSeatSelections() {
        String list = "";
        if(seatSelection.isEmpty()){
            
        }else {
            for (Seating a:seatSelection) {
                list = list + a.getSeat();
            //System.out.print(a.getSeat() + " ");
            }
        } 
        return list;
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
