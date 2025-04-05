/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

/**
 *
 * @author jbock
 */
public class Staff {
    private String name;
    private String position;
    private double payRate;
    private String password;
    
    public Staff(String name, String position, double payRate, String password){
        this.name=name;
        this.position=position;
        this.payRate=payRate;
        this.password=password;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setPosition(String position){
        this.position=position;
    }
    
    public String getPosition(){
        return position;
    }
    
    public void setPay(double payRate){
        this.payRate=payRate;
    }
    
    public double getPay(){
        return payRate;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getPassword(){
        return password;
    }
    
    @Override
    public String toString(){
        return "Staff{name: "+ name +"' position: "+position+" pay rate: "+payRate'}';
    }
}
