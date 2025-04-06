
package cs234project;

import java.util.HashSet;

/**
 * @author Michael Sanchez
 */

//variable definitions
public class Authentication {
    private Membership members;
    private EmployeeManager listOfEmployees;
    
    //Constructor to initialize members
    public Authentication(Membership members) {
        this.members = members;
    }
    
    public Authentication(EmployeeManager employee) {
        this.listOfEmployees = employee;
    }
    
    /**
     * Takes memberID (phone number) and password string.  Will then pull
     * members set by using getMembers and iterate through the members list
     * looking for a match.  If it is found, it will return the customer object.
     * returns null if not found.
     */
    public Customer AuthenticateCustomer(long id, String p) {
        for (Customer customer : members.getMembers()) {
            //Use this line to see in real time that this is iterating through the list correctly.
            //System.out.println(customer.getMemberID() + " " + customer.getPassword());
            if (customer.getMemberID() == id && customer.getPassword().equals(p)) {
                System.out.println("Welcome " + customer.getFirstName());
                return customer;
            }
        }
        System.out.println("Not a member, please register or log in as Guest.");
        return null;
    }
    
    public Staff AuthenticateStaff(String userName, String p) {
        for (Staff employee : listOfEmployees.getListOfEmployees()) {
            //Use this line to see in real time that this is iterating through the list correctly.
            //System.out.println(employee.getUserName()+ " " + employee.getPassword());
            if (employee.getUserName().equals(userName) && employee.getPassword().equals(p)) {
                System.out.println("Welcome employee " + employee.getFirstName());
                return employee;
            }
        }
        System.out.println("Staff Member not found");
        return null;
    }
}
