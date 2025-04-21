/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

/**
 *
 * @author Michael Sanchez
 */
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

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
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
        System.out.println("Card Number: " + this.creditCardNum + " \nExpiration date: " + this.expDate);
        System.out.println("-------------------------------------");
    }
}
