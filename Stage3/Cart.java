/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import java.util.ArrayList;
/**
 *
 * @author jbock
 */
public class Cart {
    private Customer customer;
    private double total;
    //private String seat;
    private ArrayList<Concession> listOfProducts;
    private ArrayList<Seating> seatSelection;
    
    public Cart(){
        this.customer=customer;
        this.listOfProducts=new ArrayList<>();
        this.seatSelection=new ArrayList<>();
        this.total = total;
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
    
    public double getTotal() {
        return total;
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
    
//    public Concession addProduct(String product, double price, int totalStock){
//        listOfProducts.add(new Concession(product,price,totalStock));
//    }
    
    public ArrayList<Concession> showProducts(){
        return listOfProducts;
    
}
    //Method to print itemized products in cart.  Can add for listOfProducts
    public void getCart() {
        for (Seating a:seatSelection) {
            System.out.println("Seat: " + a.getSeat() + " Price: $" + a.getSeatCost());
        }
    }
    
}
