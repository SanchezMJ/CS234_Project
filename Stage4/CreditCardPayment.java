/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * CreditCardPayment represents a payment made using a credit card.
 * It extends the Payment class and includes cardholder information and card details.
 * 
 * Author: Michael Sanchez
 */
// Fields for cardholder and credit card details
public class CreditCardPayment extends Payment{
    private String holdersFirstName;
    private String holdersLastName;
    private String creditCardNum;
    private String expDate;
    private int securityCode;
    
    public CreditCardPayment(double p, String first, String last, String ccNum, String xp, int sc)
    {
        super(p);
        holdersFirstName = first;
        holdersLastName = last;
        creditCardNum = ccNum;
        expDate = xp;
        securityCode = sc;
    }
    // Getter and setter for cardholder's first name
    public String getHoldersFirstName() {
        return holdersFirstName;
    }

    public void setHoldersFirstName(String holdersFirstName) {
        this.holdersFirstName = holdersFirstName;
    }
    // Getter and setter for cardholder's last name
    public String getHoldersLastName() {
        return holdersLastName;
    }

    public void setHoldersLastName(String holdersLastName) {
        this.holdersLastName = holdersLastName;
    }
    // Getter and setter for the credit card number
    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }
    // Getter and setter for the expiration date
    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
     // Getter and setter for the security code
    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

     /**
     * Displays the payment details specific to credit card payments.
     * Shows the masked card number and expiration date.
     */
    
    @Override
    public void paymentDetails() {
        
        super.paymentDetails(); // Call to Payment class method
        // Print full card number (consider masking for production use)
        System.out.println("Card Number: " + this.creditCardNum + " \nExpiration date: " + this.expDate);
        System.out.println("-------------------------------------");
    }
}
