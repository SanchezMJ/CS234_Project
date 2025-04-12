/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

import java.util.ArrayList;

/**
 *
 * @author Michael Sanchez
 */
//Defines the paymentAmountVariable
public class Payment {
    private double paymentAmount;
    private ArrayList<Payment> payments;
    
        //Constructor initializes the paymentAmount variable
    public Payment()
            {
                paymentAmount = 0;
                payments = new ArrayList<>();
            }
    //Constructor initializes the paymentAmount variable
    public Payment(double p)
            {
                paymentAmount = p;
                payments = new ArrayList<>();
            }
    //Method returns the payment amount
    public double getPaymentAmount()
    {
      return paymentAmount;  
    }
    //Method sets the payment amount to p
    public void setPaymentAmount(double p)
    {
        paymentAmount = p;
    }
    
    public void addPayment(Payment payment)
    {
        payments.add(payment);
    }
    /**
     * Method to print the amount of the payment
     */
    public void paymentDetails()
    {
        System.out.println("Payment of $" + this.getPaymentAmount());
    }

}
