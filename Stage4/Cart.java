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

/**
 * Cart class stores selected seats and concession products, calculates totals and taxes,
 * and supports receipt generation and transaction tracking.
 */
public class Cart {
    // Fields to track totals, products, and payments
    private double total;
    private ArrayList<Concession> listOfProducts;
    private ArrayList<Seating> seatSelection;
    private double tax;
    private double totalWithTax;
    private double amountPaid;

    // Constructor initializes fields
    public Cart(){
        this.listOfProducts=new ArrayList<>();
        this.seatSelection=new ArrayList<>();
        this.total = 0.0;
        this.tax = .0762;
        this.totalWithTax = 0.0;
        this.amountPaid = 0.0;
    }

    // Returns a product from the cart
    public Concession getProduct(Concession product){
        return product;
    }
    
    //Method adds a seat and increases total for Cart
    public void addSeat(Seating seat) {
        seatSelection.add(seat);
        totalWithTax = totalWithTax + seat.getSeatCost() + (seat.getSeatCost() * tax);
        total = total + seat.getSeatCost() + (seat.getSeatCost() * tax);
    }

    // Removes a seat and subtracts its cost (plus tax)
    public void remSeat(Seating seat) {

        total = total - seat.getSeatCost() - (seat.getSeatCost() * tax);
        totalWithTax = totalWithTax - seat.getSeatCost() - (seat.getSeatCost() * tax);
        seatSelection.remove(seat);
 
    }
    // Returns selected seats
    public ArrayList<Seating> getSeatSelection() {
        return seatSelection;
    }
    
    public double getTax() {
        return tax;
    }
    
    public void setTotalWithTax(double t) {
        totalWithTax = t;
    }
    
    public double getTotalWithTax() {
        return totalWithTax;
    }
    // Returns seat ID string
    public String getSeatId(Object seat) {
        Seating s = new Seating();
        String st;
        st = s.getSeat();
        return st;
    }

    // Adds payment amount to the total amount paid
    public void setAmountPaid(double p) {
        this.amountPaid = amountPaid + p;
    }

     // Resets amount paid to a specific value (e.g., 0.0)
    public void setAmountPaidZero(double z) {
        this.amountPaid = z;
    }
    public double getAmountPaid() {
        return amountPaid;
    }
    
        //Method adds selected product and increases total for Cart
    public void addProduct(Concession con) {
        listOfProducts.add(con);
        total = total + con.getPrice() + (con.getPrice()*tax);
        totalWithTax = totalWithTax + con.getPrice() + (con.getPrice()*tax);
    }

    // Removes a product and subtracts its price (plus tax)
    public void remProduct(Concession con) {
        listOfProducts.remove(con);
        total = total - con.getPrice() - (con.getPrice()*tax);
        totalWithTax = totalWithTax - con.getPrice() - (con.getPrice()*tax);
    }

    // Returns current products
    public ArrayList<Concession> showProducts(){
        return listOfProducts;
    
    }
 
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double m) {
        total = m;
    }
    // Empties both seat and product selections and resets total
    public void emptyCart(){
        seatSelection.clear();
        listOfProducts.clear();
        total=0;
    }
    // Returns selected seat labels as a string
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

     // Returns formatted cart content including tax and total, based on what was added
    public String showCart() {
        String c = "";
        System.out.println();
        double taxTotal = total * tax;
        double transTotal = total + taxTotal;
        System.out.println("showCart amountPaid = " + amountPaid);
        System.out.println("showCart totalWithTax = " + totalWithTax);
        double balance = transTotal - amountPaid;
        if (totalWithTax > 0.0 && amountPaid > 0.0) {
            if(seatSelection.isEmpty() && listOfProducts.isEmpty()){

            }else if (!seatSelection.isEmpty() && listOfProducts.isEmpty()) {
                for (Seating a:seatSelection) {
                c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
                }
                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\nTOTAL: $" + String.format("%.2f", total);
                c += "\nPaid: $" + String.format("%.2f", amountPaid);
                c += "\n\nBalance: $" + String.format("%.2f",totalWithTax);
            }else if (seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
                for (Concession p:listOfProducts) {
                c += p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
                }
                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\nTOTAL: $" + String.format("%.2f", total);
                c += "\nPaid: $" + String.format("%.2f", amountPaid);
                c += "\n\nBalance: $" + String.format("%.2f",totalWithTax);
            }else if (!seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
                for (Seating a:seatSelection) {
                c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
                }
                c += "\n";
                for (Concession p:listOfProducts) {
                c += p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
                }

                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\nTOTAL: $" + String.format("%.2f", total);
                c += "\nPaid: $" + String.format("%.2f", amountPaid);
                c += "\n\nBalance: $" + String.format("%.2f",totalWithTax);
            }
        } else {
            if(seatSelection.isEmpty() && listOfProducts.isEmpty()){

            }else if (!seatSelection.isEmpty() && listOfProducts.isEmpty()) {
                for (Seating a:seatSelection) {
                c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
                }
                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\nTOTAL: $" + String.format("%.2f", totalWithTax);
            }else if (seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
                for (Concession p:listOfProducts) {
                c += p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
                }
                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\nTOTAL: $" + String.format("%.2f", totalWithTax);
            }else if (!seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
                for (Seating a:seatSelection) {
                c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
                }
                c += "\n";
                for (Concession p:listOfProducts) {
                c += p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
                }

                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\nTOTAL: $" + String.format("%.2f", totalWithTax);
            }
        }
    return c;
    }

    // Returns cart with totals and current balance based on a passed amount
    public String showCartBalance(double paid) {
        String c = "";
        System.out.println();
        double taxTotal = total * tax;
        double transTotal = total + taxTotal;
        if(seatSelection.isEmpty() && listOfProducts.isEmpty()){
            
        }else if (!seatSelection.isEmpty() && listOfProducts.isEmpty()) {
            for (Seating a:seatSelection) {
            c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
            }
            c += "\nSales tax: $" + String.format("%.2f", taxTotal);
            //c += "\nAmount paid: " + String.format("%.2f", (paid));
            c += "\nTOTAL: $" + String.format("%.2f", totalWithTax);
            c += "\n\nAmount paid: " + String.format("%.2f", (amountPaid));
        }else if (seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
            for (Concession p:listOfProducts) {
            c += p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
            }
            c += "\nSales tax: $" + String.format("%.2f", taxTotal);
            //c += "\nAmount paid: " + String.format("%.2f", (paid));
            c += "\nTOTAL: $" + String.format("%.2f", totalWithTax);
            c += "\n\nAmount paid: " + String.format("%.2f", (amountPaid));
        }else if (!seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
            for (Seating a:seatSelection) {
            c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
            }
            c += "\n";
            for (Concession p:listOfProducts) {
            c += p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
            }
            
            c += "\nSales tax: $" + String.format("%.2f", taxTotal);
            //c += "\nAmount paid: " + String.format("%.2f", (paid));
            c += "\nTOTAL: $" + String.format("%.2f", totalWithTax);
            c += "\n\nAmount paid: " + String.format("%.2f", (amountPaid));
        }

    return c;
    }

    // Shows a final receipt without updating balance
    public String showCartReceipt(double paid) {
        String c = "";
        System.out.println();
        double taxTotal = total * tax;
        double transTotal = total + taxTotal;
        if(seatSelection.isEmpty() && listOfProducts.isEmpty()){
            
        }else if (!seatSelection.isEmpty() && listOfProducts.isEmpty()) {
            for (Seating a:seatSelection) {
            c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
            }
            c += "\nSales tax: $" + String.format("%.2f", taxTotal);
            //c += "\nAmount paid: " + String.format("%.2f", (paid));
            c += "\nTOTAL: $" + String.format("%.2f", total);
            c += "\n\nAmount paid: " + String.format("%.2f", (amountPaid));
        }else if (seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
            for (Concession p:listOfProducts) {
            c += p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
            }
            c += "\nSales tax: $" + String.format("%.2f", taxTotal);
            //c += "\nAmount paid: " + String.format("%.2f", (paid));
            c += "\nTOTAL: $" + String.format("%.2f", total);
            c += "\n\nAmount paid: " + String.format("%.2f", (amountPaid));
        }else if (!seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
            for (Seating a:seatSelection) {
            c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
            }
            c += "\n";
            for (Concession p:listOfProducts) {
            c += p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
            }
            
            c += "\nSales tax: $" + String.format("%.2f", taxTotal);
            //c += "\nAmount paid: " + String.format("%.2f", (paid));
            c += "\nTOTAL: $" + String.format("%.2f", total);
            c += "\n\nAmount paid: " + String.format("%.2f", (amountPaid));
        }

    return c;
    }
    
}
