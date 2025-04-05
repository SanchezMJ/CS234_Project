/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

/**
 *
 * @author jbock
 */

//intake for staff information
public class Staff {
    private String name;
    private String position;
    private double payRate;
    private String password;
    
    //intialises staff info
    public Staff(String name, String position, double payRate, String password){
        this.name=name;
        this.position=position;
        this.payRate=payRate;
        this.password=password;
    }
    
    //sets name
    public void setName(String name){
        this.name=name;
    }
    
    //gets name
    public String getName(){
        return name;
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
        return "name: "+name+" position: "+position+" pay rate: "+payRate;
    }
}
