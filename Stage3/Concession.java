/**
 *
 * @author jbock
 */
public class Concession {
    //sets instance variables
    private String product;
    private double price;
    private int totalStock;

    //intializes price, product, and total stock.
    public Concession(String product, double price, int totalStock){
        this.product=product;
        this.price=price;
        this.totalStock=totalStock;
        
    }

    //sets price
    public void setPrice(double price){
        this.price=price;
    }

    //gets price
    public double getPrice(){
        return price;
    }

    //set product name
    public void setProduct(String product){
        this.product=product;
    }

    //gets product name
    public String getProduct(){
        return product;
    }

    //sets total number of item in inventory
    public void setTotalStock(int totalStock){
        this.totalStock=totalStock;
    }

    //gets total number of item
    public int getTotalStock(){
        return totalStock;
    }

    //overrides out put print in a certain format
    @Override
    public String toString(){
       return product+" Price: $"+String.format("%.2f",price);
    }
    
}

