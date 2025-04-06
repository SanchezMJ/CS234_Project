/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

/**
 *
 * @author Michael Sanchez
 */
//Defines the paymentAmountVariable
public class Payment {
    private double paymentAmount;
    
    //Constructor initializes the paymentAmount variable
    public Payment(double p)
            {
                paymentAmount = p;
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
    /**
     * Method to print the amount of the payment
     */
    public void paymentDetails()
    {
        System.out.println("Payment of $" + this.getPaymentAmount());
    }

    public long getGiftCardNum() {
        return 000;
    }
}
