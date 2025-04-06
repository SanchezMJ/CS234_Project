
package cs234project;

import java.util.HashSet;

/**
 * @author Michael Sanchez
 */

//variable definitions
public class Authentication {
    private Membership members;
    
    //Constructor to initialize members
    public Authentication(Membership members) {
        this.members = members;
    }
    
    /**
     * Takes memberID (phone number) and password string.  Will then pull
     * members set by using getMembers and iterate through the members list
     * looking for a match.  If it is found, it will return the customer object.
     * returns null if not found.
     */
    public Customer Authenticate(long id, String p) {
        HashSet<Customer> test = new HashSet<>();
        test = members.getMembers();
        for (Customer customer:test) {
//        System.out.println(test);
//        for (Customer customer : members.getMembers()) {
//            System.out.println(customer.getMemberID() + " " + customer.getPassword());
            if (customer.getMemberID() == id && customer.getPassword().equals(p)) {
                System.out.println("Welcome back " + customer.getFirstName());
                return customer;
            }
        }
        return null;
    }
}
