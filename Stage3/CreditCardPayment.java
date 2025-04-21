/**
 *
 * @author Michael Sanchez
 */
public class CreditCardPayment extends Payment{
    //defines instance variables
    private String holdersFirstName;
    private String holdersLastName;
    private String creditCardNum;
    private String expDate;
    private int securityCode;

    //intializes variables and assigns values name, payment amount, credit card number, experation date, and security code
    public CreditCardPayment(double p, String first, String last, String ccNum, String xp, int sc)
    {
        super(p);
        holdersFirstName = first;
        holdersLastName = last;
        creditCardNum = ccNum;
        expDate = xp;
        securityCode = sc;
    }

    //gets the card holders first name
    public String getHoldersFirstName() {
        return holdersFirstName;
    }

    //sets the cards holders first name
    public void setHoldersFirstName(String holdersFirstName) {
        this.holdersFirstName = holdersFirstName;
    }

    //gets the card holders last name
    public String getHoldersLastName() {
        return holdersLastName;
    }

    //sets the card holders last name
    public void setHoldersLastName(String holdersLastName) {
        this.holdersLastName = holdersLastName;
    }

    //gets the credit card number
    public String getCreditCardNum() {
        return creditCardNum;
    }

    //sets the credit card number
    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    //gets the card experation date
    public String getExpDate() {
        return expDate;
    }

    //sets the card experation date
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    //gets the cards security code
    public int getSecurityCode() {
        return securityCode;
    }

    //sets the card security code
    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    //overrides payment details and prints particular format
    @Override
    public void paymentDetails() {
        
        super.paymentDetails();
        System.out.println("Card Number: " + this.creditCardNum + " \nExpiration date: " + this.expDate);
        System.out.println("-------------------------------------");
    }
}
