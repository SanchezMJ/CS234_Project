/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
/**
 *
 * @author jbock
 */
public class Cart {
    private Customer customer;
    private ArrayList<Concession> listOfProducts;
    private ArrayList<Seating> seatSelection;
    private Payment payment;
    private Inventory productList;
    
    public Cart(Customer customer, Inventory productList){
        this.customer=customer;
        this.listOfProducts=new ArrayList<>();
        this.seatSelection=new ArrayList<>();
        this.productList= productList;
        
    }
    
    public void addProduct(String productName){
        for(Concession product: productList.getProductList()){
            if(product.getProduct().equals(productName)){
                listOfProducts.add(product);
                return;
            }
        }
        System.out.println("Item not found.");
    }
    
    public void removeProduct(Concession product){
        listOfProducts.remove(product);
    }
    
    public void showProducts(){
        if(listOfProducts.isEmpty()){
            System.out.println("List of products is empty.");
        }else{
        for (Concession product : listOfProducts){
            System.out.println(product);
        }
      }
        
    }
    
    public void addSeat(Seating seat){
        seatSelection.add(seat);
    }
    
    public void removeSeat(Seating seat){
        seatSelection.remove(seat);
    }
    
    public void showSeats(){
        if(seatSelection.isEmpty()){
            System.out.println("No seats selected.");
        }else{
        for (Seating seat : seatSelection){
            System.out.println(seat);
        }
      }
        
    }
    
    public double totalCost(){
        double total=0;
        for(Concession product: listOfProducts){
            total=total+product.getPrice();
        }
        
        for(Seating seat: seatSelection){
            total=total+seat.getSeatCost();
        }
        
        return total;
    }
    
    public void transaction(){
        System.out.println("Customer: "+customer.getFirstName()+" "+customer.getLastName());
        System.out.println("Products: ");
        showProducts();
        System.out.println("Seats: ");
        showSeats();
        double total=totalCost();
        System.out.println("Total: $"+total);
        
        payment=new Payment(total);
        payment.paymentDetails();
    }
   
    
    
    
    
}
    
