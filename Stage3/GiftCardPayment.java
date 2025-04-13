/**
 *
 * @author Michael Sanchez
 */
public class GiftCardPayment extends Payment {
    private String giftCardNum;
    private String expDate;
    
    GiftCardPayment(double p, String gcn, String xp) {
        super(p);
        giftCardNum = gcn;
        expDate = xp;
    }       
    
    public String getGiftCardNum() {
        return giftCardNum;
    }

    public void setGiftCardNum(String giftCardNum) {
        this.giftCardNum = giftCardNum;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
    
    @Override
    public void paymentDetails() {
        
        super.paymentDetails();
        System.out.println("Gift Card Number: " + this.giftCardNum);
        //System.out.println("Remaining Balance: " + getRemainingBalance());
        System.out.println("-------------------------------------");
    }
}
