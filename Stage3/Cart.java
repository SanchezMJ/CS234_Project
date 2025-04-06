/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
/**
 *
 * @author jbock
 */
//collects information to finalize transaction
public class Cart {
    private Customer customer;
    private ArrayList<Concession> listOfProducts;
    private ArrayList<Seating> seatSelection;
    private Payment payment;
    private Inventory productList;

    //intializes cart
    public Cart(Customer customer, Inventory productList){
        this.customer=customer;
        this.listOfProducts=new ArrayList<>();
        this.seatSelection=new ArrayList<>();
        this.productList= productList;
        
    }

    //adds product to cart from inventory
    public void addProduct(String productName){
        for(Concession product: productList.getProductList()){
            if(product.getProduct().equals(productName)){
                listOfProducts.add(product);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    //removes product
    public void removeProduct(Concession product){
        listOfProducts.remove(product);
    }

    //shows products in cart
    public void showProducts(){
        if(listOfProducts.isEmpty()){
            System.out.println("List of products is empty.");
        }else{
        for (Concession product : listOfProducts){
            System.out.println(product);
        }
      }
        
    }

    //adds seat to cart
    public void addSeat(Seating seat){
        seatSelection.add(seat);
    }

    //removes seat from cart
    public void removeSeat(Seating seat){
        seatSelection.remove(seat);
    }

    //shows selected seats
    public void showSeats(){
        if(seatSelection.isEmpty()){
            System.out.println("No seats selected.");
        }else{
        for (Seating seat : seatSelection){
            System.out.println(seat);
        }
      }
        
    }

    //adds cost of concession and seating
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

    //prints customer name, total, and items purchased
    //passes total to payment class
    public void transaction(){
        System.out.println("Customer: "+customer.getFirstName()+" "+customer.getLastName());
        System.out.println("Products: ");
        showProducts();
        System.out.println("Seats: ");
        showSeats();
        double total=totalCost();
        System.out.println("Total: $"+total);
        
        //checks if customer is member and awards points if true.
        if(customer.getMemberID()!=0){
            int pointsToAdd=(int)(total/10);
            customer.addPoints(pointsToAdd);
            System.out.println("Points added; "+pointsToAdd+" points.");
            System.out.println("Total point: "+customer.getPoints());
            
        }else{
            System.out.println("Customer is not a member.");
        }
        
        
        
        payment=new Payment(total);
        payment.paymentDetails();
    }
   
    
    
    
    
}
    
