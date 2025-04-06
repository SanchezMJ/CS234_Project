
package cs234project;

import java.util.HashSet;

/**
 * @author Michael Sanchez
 */

//Variable definitions
public class Membership {
    private HashSet<Customer> members;
    
    //initializes members set.
    public Membership () {
        this.members = new HashSet<>();
    }
    
    /**
     * Method to check if user is a member.
     */
    public boolean isMember(long id) {
        for (Customer m : members) {
            if (m.getMemberID() == id) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method that checks if customer is already in members list before
     * proceeding to add member into the list. 
     */
    public void addMembers(Customer customer) {
        boolean cont = members.contains(customer);
        if (cont == false) {
            members.add(customer);
            System.out.println("Welcome to our Theater " + customer.getFirstName() + "!");
        } else {
            System.out.println("Please try password again.");
        }
    }
    
    //Method checks to see if Customer is in the members list before removal.
    public void removeMembers(Customer customer) {
        members.remove(customer);
    }
    
    public HashSet<Customer> getMembers() {
        return members;
    }
    public void getMember() {
        for (Customer m : members) {
            System.out.println(m.getFirstName() + " " + m.getLastName());
            System.out.println("Member ID: " + m.getMemberID() + " Points: " + m.getPoints());
        }
    }
}
