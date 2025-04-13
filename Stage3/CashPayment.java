/**
 *
 * @author mjsanchez
 */
public class CashPayment extends Payment{

    //sets instance variable for cash amount.
    private double cashAmount;

    //passes the cash payment to pay for the payment amount.
    CashPayment(double p, double ca){
        super(p);
        cashAmount = ca;
    }

    //gets cash amount
    public double getCashAmount() {
        return cashAmount;
    }

    //sets the cash amount
    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }

    //overides out to payment to show in specific format
    @Override
    public void paymentDetails() {
        
        super.paymentDetails();
        System.out.println("Cash: " + this.cashAmount);
        System.out.println("-------------------------------------");
    }
}
