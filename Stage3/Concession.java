/**
 *
 * @author jbock
 */
public class Concession {
    private String product;
    private double price;
    private int totalStock;
    
    public Concession(String product, double price, int totalStock){
        this.product=product;
        this.price=price;
        this.totalStock=totalStock;
        
    }
    
    public void setPrice(double price){
        this.price=price;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setProduct(String product){
        this.product=product;
    }
    
    public String getProduct(){
        return product;
    }
    
    public void setTotalStock(int totalStock){
        this.totalStock=totalStock;
    }
    
    public int getTotalStock(){
        return totalStock;
    }
    
    @Override
    public String toString(){
       return product+" Price: $"+String.format("%.2f",price);
    }
    
}

