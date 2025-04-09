/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

/**
 *
 * @author jbock
 */

//intake for staff information
public class Staff {
    private String firstName;
    private String lastName;
    private String position;
    private double payRate;
    private String userName;
    private String password;
    
    //intialises staff info
    public Staff(){
        this.firstName = null;
        this.lastName = null;
        this.position=null;
        this.payRate=0;
        this.userName = null;
        this.password=null;
    }

    public Staff(String firstName, String lastName, String position, double payRate, String userName, String password){
        this.firstName=firstName;
        this.lastName = lastName;
        this.position=position;
        this.payRate=payRate;
        this.userName = userName;
        this.password=password;
    }
    
    //sets name
    public void setFirstName(String name){
        this.firstName=name;
    }
    
    //gets name
    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    //set position
    public void setPosition(String position){
        this.position=position;
    }
    
    //gets position
    public String getPosition(){
        return position;
    }
    
    //sets pay rate
    public void setPay(double payRate){
        this.payRate=payRate;
    }
    
    //gets pay rate
    public double getPay(){
        return payRate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    //sets password
    public void setPassword(String password){
        this.password=password;
    }
    
    //gets password
    public String getPassword(){
        return password;
    }
    
    //overides showEmployees() in manager to display info in a row
    @Override
    public String toString(){
        return "name: "+ firstName + " " + lastName + " position: "+position+" pay rate: "+payRate;
    }
}
