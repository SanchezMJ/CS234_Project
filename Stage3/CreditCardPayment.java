/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

/**
 *
 * @author Michael Sanchez
 */
public class CreditCardPayment extends Payment{
    private String holdersFirstName;
    private String holdersLastName;
    private int creditCardNum;
    private String expDate;
    private int securityCode;
    
    CreditCardPayment(double p, String first, String last, int ccNum, String xp, int sc)
    {
        super(p);
        holdersFirstName = first;
        holdersLastName = last;
        creditCardNum = ccNum;
        expDate = xp;
        securityCode = sc;
    }

    public String getHoldersFirstName() {
        return holdersFirstName;
    }

    public void setHoldersFirstName(String holdersFirstName) {
        this.holdersFirstName = holdersFirstName;
    }

    public String getHoldersLastName() {
        return holdersLastName;
    }

    public void setHoldersLastName(String holdersLastName) {
        this.holdersLastName = holdersLastName;
    }

    public int getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(int creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }
    
    @Override
    public void paymentDetails() {
        
        super.paymentDetails();
        System.out.println("Card Number: " + this.creditCardNum + " \n Expiration date: " + this.expDate);
        System.out.println("-------------------------------------");
    }
}
