/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

/**
 *
 * @author mjsanchez
 */
public class GiftCards {
    private long giftCardNumber;
    private String expDate;
    private double giftCardBalance;
    private ArrayList<GiftCards>giftCards;
    
    public GiftCards(long gcn, String xp, double gcb) {
        giftCardNumber = gcn;
        expDate = xp;
        giftCardBalance = gcb;
        giftCards = new ArrayList();
    }       

    public long getGiftCardNumber() {
        return giftCardNumber;
    }

    public void setGiftCardNumber(long giftCardNum) {
        this.giftCardNumber = giftCardNum;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public double getGiftCardBalance() {
        return giftCardBalance;
    }

    public void setGiftCardBalance(double giftCardBalance) {
        this.giftCardBalance = giftCardBalance;
    }
    
        //Adds object from Payment class to ArrayList payments.
    public void addGiftCard(GiftCards giftCard)
    {
        giftCards.add(giftCard);
    }
    public boolean isGiftCard(long cn) {
        for (GiftCards giftCard : giftCards) {
            if (giftCard.getGiftCardNumber()==(cn)) {
                return true;
            }
        }
        return false;
    }
}
