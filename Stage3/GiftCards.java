import java.util.ArrayList;

/**
 *
 * @author mjsanchez
 */
public class GiftCards {
    //defines instance varables
    private long giftCardNumber;
    private String expDate;
    private double giftCardBalance;
    private ArrayList<GiftCards>giftCards;

    //intializes variable for gift card number, experiation date, and giftcard balance
    GiftCards(long gcn, String xp, double gcb) {
        giftCardNumber = gcn;
        expDate = xp;
        giftCardBalance = gcb;
        giftCards = new ArrayList<>();
    }       

    //gets gift card number
    public long getGiftCardNumber() {
        return giftCardNumber;
    }

    //sets gift card number
    public void setGiftCardNumber(long giftCardNum) {
        this.giftCardNumber = giftCardNum;
    }

    //gets experation date
    public String getExpDate() {
        return expDate;
    }

    //sets experation date
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    //gets gift card balance
    public double getGiftCardBalance() {
        return giftCardBalance;
    }

    //sets gift card balance
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
