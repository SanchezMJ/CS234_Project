/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * CashPayment represents a payment made using physical cash.
 * It extends the Payment superclass and adds functionality specific to cash.
 * 
 * Author: mjsanchez
 */
public class CashPayment extends Payment{
    // Amount of cash received from the customer
    private double cashAmount;
    
    public CashPayment(double p, double ca){
        super(p);
        cashAmount = ca;
    }

    public double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }
    
    @Override
    /**
     * Displays details of the cash payment, including inherited price info and the cash amount.
     */
    public void paymentDetails() {
        
        super.paymentDetails();
        System.out.println("Cash: " + this.cashAmount);
        System.out.println("-------------------------------------");
    }
}
