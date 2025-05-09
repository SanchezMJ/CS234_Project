/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        File file = new File(filepath);
        
        if(!file.exists()){
            System.err.println("File not found: "+filepath);
            return;
        }
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"UTF-8"))){
            String line;
            while((line=br.readLine())!=null){
                
                if(line.trim().isEmpty()) continue;
                
                String[] parts=line.split(",");
                if((parts.length)>=3){
                    String name = parts[0].trim();
                    try{
                        double price = Double.parseDouble(parts[1].trim());
                        int totalStock=Integer.parseInt(parts[2].trim());
                        
                        if (price>=0&&totalStock>=0){
                    Concession product = new Concession(name,price,totalStock);
                    addProduct(product);
                        }else{
                            System.err.println("Invalid price or stock: "+name);
                        }
                    }catch(NumberFormatException e){
                        System.err.println("Error parsing price or stock:"+line);
                    }
                    }else{
                            System.err.println("Invalid format"+line);
                            }
                    }
        
            System.out.println("Inventory imported successfully.");
        }catch(IOException e){
            System.err.println("Error importing inventory: "+e.getMessage());
        
        }
    }
    
    public void updateCSV(String filename){
        try(PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for(Concession item: productList){
            writer.println(item.getProduct()+","+item.getPrice()+","+item.getTotalStock());
        }
    }catch(IOException e){
    e.printStackTrace();
}
}
}
