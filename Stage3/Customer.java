/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

public class Customer {
	private String firstName; 
	private String lastName;
	private String dob;
	private int  memberID;  
	private int points; 
	private ArrayList<Customer> members;
	
	public Customer() {
		this.firstName = "";
		this.lastName = "";
		this.dob = "";
		this.memberID = 0;
		this.points = 0;  
		this.members = new ArrayList<>();
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
	
	public String getFirstName() {
		return lastName;
	}
	
	
	public void setDOB(String dob) {
		this.dob = dob;
	}
	
	public String getdob() {
		return dob;
	}
	
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
}
