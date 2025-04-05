/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import java.util.HashSet;

/**
 * @author Michael Sanchez
 */
public class Membership {
    private HashSet<Customer> members;
    
    public Membership () {
        this.members = new HashSet<>();
    }
    
    public void isMember(Customer customer) {
        boolean cont = members.contains(customer);
        if (cont == false) {
            members.add(customer);
            System.out.println(customer.getFirstName() + " is a member.");
        } else {
            System.out.println("No user found.");
        }
    }
    
    public void addMembers(Customer customer) {
        boolean cont = members.contains(customer);
        if (cont == false) {
            members.add(customer);
            System.out.println("Welcome to our Theater " + customer.getFirstName() + "!");
        } else {
            System.out.println("User exists, please try password again.");
        }
    }

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
