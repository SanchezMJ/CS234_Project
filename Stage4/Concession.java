/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Concession represents an item sold at the theater (e.g., snacks, drinks).
 * It contains the product's name, price, and stock quantity.
 * 
 * Author: jbock
 */
public class Concession {
    //sets instance variables
    private String product; // Name of the concession item
    private double price; // Price of the item
    private int totalStock; // Quantity in stock
    
    //intializes instance variables
    public Concession(String product, double price, int totalStock){
        this.product=product;
        this.price=price;
        this.totalStock=totalStock;
        
    }
    
    //sets price
    public void setPrice(double price){
        this.price=price;
    }
    
    //gets price
    public double getPrice(){
        return price;
    }
    
    //sets product name
    public void setProduct(String product){
        this.product=product;
    }
    
    //gets product name
    public String getProduct(){
        return product;
    }
    
    //sets amount in stock
    public void setTotalStock(int totalStock){
        this.totalStock=totalStock;
    }
    
    //gets amount in stock
    public int getTotalStock(){
        return totalStock;
    }
    
    //looks to see if theres enough product in stock
    public boolean checkStock(int quantity){
        return totalStock>=quantity;
    }
    
    //reduces stock after purchase
    public void reduceStock(int quantity){
        if(checkStock(quantity)){
            totalStock=totalStock-quantity;
        }else{
            System.out.println("Out of Stock");
        }
    }
    
    //formats price to two decimal places
    @Override
    public String toString(){
       return product+" Price: $"+String.format("%.2f",price)+" Stock: "+totalStock+"\n";
    }
    
    //checks to see if a value = null
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Concession))return false;
        Concession other=(Concession)o;
        return product!=null&&product.equalsIgnoreCase(other.product);
    }
    
    //checks for case sensitivity
    @Override
    public int hashCode(){
        return product!=null?product.toLowerCase().hashCode():0;
    }
    
}

