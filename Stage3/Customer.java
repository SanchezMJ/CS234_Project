/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import java.util.ArrayList;
import java.util.Objects;

public class Customer {
	private String firstName; 
	private String lastName;
	private String dob;
        private String password;
	private long  memberID;  
	private int points; 
        
	//private ArrayList<Customer> members;
	
	public Customer() {
		this.firstName = "Guest";
		this.lastName = null;
		this.dob = null;
		this.memberID = 0000000001L;
		this.points = 0; 
                this.password = null;
		//this.members = new ArrayList<>();
	}
        
        public Customer(String n, String l, String d, long mid, String pass) {
		this.firstName = n;
		this.lastName = l;
		this.dob = d;
		this.memberID = mid;
		this.points = 0;
                this.password = pass;
		//this.members = new ArrayList<>();
        }
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setDOB(String dob) {
		this.dob = dob;
	}
	
	public String getdob() {
		return dob;
	}
	
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
        
	public long getMemberID() {
		return memberID;
	}
        public void addPoints(int p) {
            this.points = points + p;
        }
        
        public void removePoints(int p) {
            if ((points - p) >= 0) {
                this.points = points - p;
            }else {
                this.points = 0;
            }
        }
            
        public int getPoints() {
            return points;
        }
        
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    
            //Overwrites method hashCode for sorting objects
    @Override
    public int hashCode() {
        //Uses modulus operator and 10 to sort by remainder
        int check = (int)memberID;
        return Objects.hash(check);
    }
    
    //Necessarily overrides equals method to verify if object exists in set
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