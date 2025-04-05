/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

import java.util.ArrayList;

/**
 *
 * @author jbock
 */
public class EmployeeManager {
    private ArrayList<Staff>listOfEmployees;
    
    public EmployeeManager(){
        this.listOfEmployees=new ArrayList<>();
    }
    public void addEmployee(Staff newStaff){
        listOfEmployees.add(newStaff);
    }
    
    public void removeEmployee(Staff name){
        listOfEmployees.remove(name);
    }
    
    public void setListOfEmployees(ArrayList<Staff> listOfEmployees){
        this.listOfEmployees=listOfEmployees;
    }
    
    public ArrayList<Staff> getListOfEmployees(){
        return listOfEmployees;
    }
    
    public void showEmployees(){
        if(listOfEmployees.isEmpty()){
            System.out.println("List of employees is empty.");
        }else{
        for (Staff employee : listOfEmployees){
            System.out.println(employee);
        }
      }
        
    }
    
}

