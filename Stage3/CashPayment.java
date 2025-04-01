/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

/**
 *
 * @author mjsanchez
 */
public class CashPayment extends Payment{
    private double cashAmount;
    
    CashPayment(double p, double ca){
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
    public void paymentDetails() {
        
        super.paymentDetails();
        System.out.println("Cash: " + this.cashAmount);
        System.out.println("-------------------------------------");
    }
}
