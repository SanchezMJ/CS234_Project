/**
 * @author Michael Sanchez
 */

//Variable definitions
public class Customer {
	private String firstName; 
	private String lastName;
	private String dob;
        private String password;
	private long  memberID;  
	private double points; 
        private Membership members;
	
        //Constructor for default/Guest user
	public Customer() {
		this.firstName = "Guest";
		this.lastName = null;
		this.dob = null;
		this.memberID = 0000000001L;
		this.points = 0; 
                this.password = null;
                //this.members = members;
	}
        
        /**
         * Constructor and variable initialization for Users
         * @param memberID will be the members phone number and has to be long
         * so make sure to add L after the phone number to prevent errors.
         */
        public Customer(String n, String l, String d, long mid, String pass) {
		this.firstName = n;
		this.lastName = l;
		this.dob = d;
		this.memberID = mid;
		this.points = 0;
                this.password = pass;
        }
	
        //Method to set users first name.
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
        //Method to return users first name.
	public String getFirstName() {
		return firstName;
	}
	
        //Method to set last name of user.
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
        //Method to return last name of user.
	public String getLastName() {
		return lastName;
	}
	
        //Method to set DOB of user
	public void setDOB(String dob) {
		this.dob = dob;
	}
	
        //Method to get DOB of user
	public String getdob() {
		return dob;
	}
	
        //Method to set memberID of user.
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
        
        //Method to return memberID
	public long getMemberID() {
		return memberID;
	}
        
        //Method to add points to each customer
        public void addPoints(double amount) {
                double p = amount/10.0;
                this.points = points + p;
        }
        
        /**
         * Method to remove points from customer while ensuring
         * that the point value does not go below zero or that they have
         * enough points for transaction.
         */
        public void removePoints(double p) {
            if ((points - p) >= 0) {
                this.points = points - p;
            }else {
                System.out.println("Not enough points for transaction.");
            }
        }
        
        //Method to return points for customer.
        public double getPoints() {
            return points;
        }
        
        //Method to return customers password
        public String getPassword() {
            return password;
        }
        
        //Method to set customer passwod.
        public void setPassword(String password) {
            this.password = password;
        }
        
        @Override
        public String toString() {
            return "Name: " + firstName + " " + lastName + "\n" + "Birthday: " 
                    + dob + "\nPoints: " + points; 
        }
        
//        public static Customer createCustomer(int id) {
//            return new Customer(id);
//        }
        /**
         * Takes DOB string and will subtract from current date to get age.
         * Was planning on using this to maybe use for R rated movies.  
         * Most likely wont use it at all.
         */
        
//        public int getAge() {
//            int age = dob - currentDate;
//            return age;
//        }
    
    //Overwrites method hashCode for sorting objects
    @Override
    public int hashCode() {
        //Uses modulus operator and 10 to sort by remainder
        int check = (int)memberID;
        return check;
    }
    
    /**
     * Necessarily overrides equals method to verify if object exists in set
     * Uses memberID (phone number) to check for duplicate entries.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Customer)) {
            return false;
        }
        
        Customer patient = (Customer) obj;
        return memberID == patient.memberID;
    }
}
