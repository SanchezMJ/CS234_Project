/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author mjsanchez
 */
public class Authentication {
    private Membership members;
    
    public Authentication(Membership members) {
        this.members = members;
    }
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
