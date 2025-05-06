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
    private double total;
    private ArrayList<Concession> listOfProducts;
    private ArrayList<Seating> seatSelection;
    private double tax;
    private double totalWithTax;
    private double amountPaid;
    
    public Cart(){
        this.listOfProducts=new ArrayList<>();
        this.seatSelection=new ArrayList<>();
        this.total = 0.0;
        this.tax = .0762;
        this.totalWithTax = 0.0;
        this.amountPaid = 0.0;
    }
    
    public Concession getProduct(Concession product){
        return product;
    }
    
    //Method adds a seat and increases total for Cart
    public void addSeat(Seating seat) {
        seatSelection.add(seat);
        totalWithTax = total + seat.getSeatCost() + (seat.getSeatCost() * tax);
        total = total + seat.getSeatCost();
    }
    
    public void remSeat(Seating seat) {

        total = total - seat.getSeatCost();
        totalWithTax = total - seat.getSeatCost() - (seat.getSeatCost() * tax);
        seatSelection.remove(seat);
 
    }
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
    public String getSeatId(Object seat) {
        Seating s = new Seating();
        String st;
        st = s.getSeat();
        return st;
    }
    
    public void setAmountPaid(double p) {
        this.amountPaid = amountPaid + p;
    }
    
    public double getAmountPaid() {
        return amountPaid;
    }
    
        //Method adds selected product and increases total for Cart
    public void addProduct(Concession con) {
        listOfProducts.add(con);
        total = total + con.getPrice();
        totalWithTax = total + con.getPrice() + (con.getPrice()*tax);
    }
    
    public void remProduct(Concession con) {
        listOfProducts.remove(con);
        total = total - con.getPrice();
        totalWithTax = total - con.getPrice() - (con.getPrice()*tax);
    }
    
    public ArrayList<Concession> showProducts(){
        return listOfProducts;
    
    }
 
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double m) {
        total = m;
    }
    public void emptyCart(){
        seatSelection.clear();
        listOfProducts.clear();
        total=0;
    }
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
    
    public String showCart() {
        String c = "";
        System.out.println();
        double taxTotal = total * tax;
        double transTotal = total + taxTotal;
        double balance = transTotal - amountPaid;
        if (totalWithTax > 0.0 && amountPaid > 0.0) {
            if(seatSelection.isEmpty() && listOfProducts.isEmpty()){

            }else if (!seatSelection.isEmpty() && listOfProducts.isEmpty()) {
                for (Seating a:seatSelection) {
                c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
                }
                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\nTOTAL: $" + String.format("%.2f", transTotal);
                c += "\nPaid: $" + String.format("%.2f", amountPaid);
                c += "\n\nBalance: $" + String.format("%.2f",balance);
            }else if (seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
                for (Concession p:listOfProducts) {
                c += "Seat: " + p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
                }
                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\nTOTAL: $" + String.format("%.2f", transTotal);
                c += "\nPaid: $" + String.format("%.2f", amountPaid);
                c += "\n\nBalance: $" + String.format("%.2f",balance);
            }else if (!seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
                for (Seating a:seatSelection) {
                c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
                }
                for (Concession p:listOfProducts) {
                c += "\nSeat: " + p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
                }

                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\n\nTOTAL: $" + String.format("%.2f", transTotal);
                c += "\nPaid: $" + String.format("%.2f", amountPaid);
                c += "\n\nBalance: $" + String.format("%.2f",balance);
            }
        } else {
            if(seatSelection.isEmpty() && listOfProducts.isEmpty()){

            }else if (!seatSelection.isEmpty() && listOfProducts.isEmpty()) {
                for (Seating a:seatSelection) {
                c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
                }
                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\nTOTAL: $" + String.format("%.2f", transTotal);
            }else if (seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
                for (Concession p:listOfProducts) {
                c += "Seat: " + p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
                }
                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\nTOTAL: $" + String.format("%.2f", transTotal);
            }else if (!seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
                for (Seating a:seatSelection) {
                c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
                }
                for (Concession p:listOfProducts) {
                c += "\nSeat: " + p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
                }

                c += "\nSales tax: $" + String.format("%.2f", taxTotal);
                c += "\n\nTOTAL: $" + String.format("%.2f", transTotal);
            }
        }
    return c;
    }
    
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
            c += "\nAmount paid: -" + String.format("%.2f", (paid));
            c += "\nTOTAL: $" + String.format("%.2f", totalWithTax);
        }else if (seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
            for (Concession p:listOfProducts) {
            c += "Seat: " + p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
            }
            c += "\nSales tax: $" + String.format("%.2f", taxTotal);
            c += "\nAmount paid: -" + String.format("%.2f", (paid));
            c += "\nTOTAL: $" + String.format("%.2f", totalWithTax);
        }else if (!seatSelection.isEmpty() && !listOfProducts.isEmpty()) {
            for (Seating a:seatSelection) {
            c += "Seat: " + a.getSeat() + " Price: $" + String.format("%.2f",a.getSeatCost()) + "\n";
            }
            for (Concession p:listOfProducts) {
            c += "\nSeat: " + p.getProduct() + " Price: $" + String.format("%.2f",p.getPrice()) + "\n";
            }
            
            c += "\nSales tax: $" + String.format("%.2f", taxTotal);
            c += "\nAmount paid: -" + String.format("%.2f", (paid));
            c += "\n\nTOTAL: $" + String.format("%.2f", totalWithTax);
        }

    return c;
    }
    
}
