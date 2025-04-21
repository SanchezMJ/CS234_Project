/**
 *
 * @author Michael Sanchez
 */
public class GiftCardPayment extends Payment {
    //defines instance variables gift card number and experation date
    private String giftCardNum;
    private String expDate;

    //intializes variable and pulls information for payment, giftcard number, and experation date
    public GiftCardPayment(double p, String gcn, String xp) {
        super(p);
        giftCardNum = gcn;
        expDate = xp;
    }       

    //gets gift card number
    public String getGiftCardNum() {
        return giftCardNum;
    }

    //sets gift card number
    public void setGiftCardNum(String giftCardNum) {
        this.giftCardNum = giftCardNum;
    }

    //gets the experation date
    public String getExpDate() {
        return expDate;
    }

    //sets the experation date
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    //ovverides out put to print in a specific format
    @Override
    public void paymentDetails() {
        
        super.paymentDetails();
        System.out.println("Gift Card Number: " + this.giftCardNum);
        //System.out.println("Remaining Balance: " + getRemainingBalance());
        System.out.println("-------------------------------------");
    }
}
