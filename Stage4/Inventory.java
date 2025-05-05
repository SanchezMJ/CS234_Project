/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    
    public Concession findProductByName(String name){
        for(Concession product: productList){
            if(product.getProduct().equalsIgnoreCase(name)){
                return product;
            }
        }
        return null;
    }
    
    public void importInventory(String filepath)throws IOException{
        productList.clear();
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            String line;
            while((line=br.readLine())!=null){
            String[] parts=line.split(",");
            if((parts.length)>=3){
                String name = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());
                int totalStock=Integer.parseInt(parts[2].trim());
                
                Concession product = new Concession(name,price,totalStock);
                addProduct(product);
           
            }
        }
            System.out.println("Inventory imported successfully.");
        }catch(IOException|NumberFormatException e){
            System.err.println("Error importing inventory: "+e.getMessage());
        
        }
    }
}
