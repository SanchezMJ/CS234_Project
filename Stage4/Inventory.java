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
//stores inventory for concession
public class Inventory {
    private ArrayList<Concession> productList;

    //intialises inventory list
    public Inventory(){
    productList=new ArrayList<>();
}
    //add product to inventory
    public void addProduct(Concession product){
        productList.add(product);
    }

    //removes product
    public void removeProduct(Concession product){
        productList.remove(product);
    }

    //gets product list
    public ArrayList<Concession> getProductList(){
        return productList;
    }
    
    public Concession findProductByName(String name){
        for(Concession product: productList){
            if(product.getProduct().equalsIgnoreCase(name)){
                return product;
            }
        }
        return null;
    }

    //show inventory list if anything is in it
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
