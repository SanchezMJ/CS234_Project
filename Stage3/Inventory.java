import java.util.ArrayList;
/**
 *
 * @author jbock
 */
//stores inventory for concession
public class Inventory {
    private ArrayList<Concession> productList;

    //intialises inventory list
    public Inventory(){
    productList=new ArrayList<>();
}
    //add product to inventory
    public void addProduct(Concession product){
        productList.add(product);
    }

    //removes product
    public void removeProduct(Concession product){
        productList.remove(product);
    }

    //gets product list
    public ArrayList<Concession> getProductList(){
        return productList;
    }

    //show inventory list if anything is in it
    public void showAllProducts(){
        if (productList.isEmpty()){
            System.out.println("No products in inventory.");
        }else{
            for(Concession product:productList){
                System.out.println(product);
            }
        }
    }
}
