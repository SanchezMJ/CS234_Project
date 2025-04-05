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
    private Customer customer;
    private ArrayList<Concession> listOfProducts;
    private ArrayList<Seating> seatSelection;
    
    public Cart(){
        this.customer=customer;
        this.listOfProducts=new ArrayList<>();
        this.seatSelection=new ArrayList<>();
        
    }
    
    public void addPoints(Customer customer){
        
    }
    
    public void payOut(Payment payment){
        
    }
    
    public Concession getProduct(Concession product){
        return product;
    }
    
    public Concession addProduct(String product, double price, int totalStock){
        listOfProducts.add(new Concession(product,price,totalStock));
    }
    
    public ArrayList<Concession> showProducts(){
        return listOfProducts;
    
}
    
}
