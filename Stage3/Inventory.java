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
public class Inventory {
    private ArrayList<Concession> productList;
    
    public Inventory(){
    productList=new ArrayList<>();
}
    
    public void addProduct(Concession product){
        productList.add(product);
    }
    
    public void removeProduct(Concession product){
        productList.remove(product);
    }
    
    public ArrayList<Concession> getProductList(){
        return productList;
    }
    
    public void showAllProducts(){
        if (productList.isEmpty()){
            System.out.println("No products in inventory.");
        }else{
            for(Concession product:productList){
                System.out.println(product);
            }
        }
    }
}
