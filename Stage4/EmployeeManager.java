/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author jbock
 */

//Manages Employees
public class EmployeeManager {
    private ArrayList<Staff>listOfEmployees;
    
    //intialies employee list
    public EmployeeManager(){
        this.listOfEmployees=new ArrayList<>();
    }
    
    //add employee to list
    public void addEmployee(Staff newStaff){
        listOfEmployees.add(newStaff);
    }
    
    //removes employee from list
    public void removeEmployee(Staff name){
        listOfEmployees.remove(name);
    }
    
    //sets list of employees
    public void setListOfEmployees(ArrayList<Staff> listOfEmployees){
        this.listOfEmployees=listOfEmployees;
    }
    
    //gets list of employees
    public ArrayList<Staff> getListOfEmployees(){
        return listOfEmployees;
    }
    
    //shows list of employees
    public void showEmployees(){
        if(listOfEmployees.isEmpty()){
            System.out.println("List of employees is empty.");
        }else{
        for (Staff employee : listOfEmployees){
            System.out.println(employee);
        }
    }
        
    }
    
    //shows list of employees
    public String displayEmployees(){
        String staff = "";
        for (Staff m:listOfEmployees) {
            staff += m.getFirstName() + " " + m.getLastName() + "\n";
            staff += "Position: " + m.getPosition() + " Pay rate: " + m.getPay() + "\n";
            staff += "User name: " + m.getUserName() + " " + "Password: " + m.getPassword() + "\n";
            staff += "------------------------------------------\n\n";
        }
        return staff;
    }
    //imports staff from csv file
    public void importStaff(String filepath)throws IOException{
        listOfEmployees.clear();
        File file = new File(filepath);
        
        //shows a message if file not found
        if(!file.exists()){
            System.err.println("File not found: "+filepath);
            return;
        }
        
        //reads from csv and imports information
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"UTF-8"))){
            String line;
            while((line=br.readLine())!=null){
                if(line.trim().isEmpty()) continue;
                String[] parts=line.split(",");
                if((parts.length)>=6){
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    String position = parts[2];
                    String payRateStr=parts[3].trim();
                    String userName = parts[4];
                    String password = parts[5];
                    try{
                        double payRate = Double.parseDouble(payRateStr);
                        if (payRate>=0){
                    Staff staff = new Staff(firstName,lastName,position,payRate,userName,password);
                    addEmployee(staff);
                        }else{
                            System.err.println("Invalid pay rate: "+payRate);
                        }
                    }catch(NumberFormatException e){
                        System.err.println("Error parsing price or stock:"+line);
                    }
                    }else{
                            System.err.println("Invalid format"+line);
                            }
                    }
        
            System.out.println("Staff imported successfully.");
        }catch(IOException e){
            System.err.println("Error importing staff: "+e.getMessage());
        
        }
    }
    
    //updates csv based on changes made
    public void updateCSV(String filename){
        try(PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for(Staff staff: listOfEmployees){
            writer.println(staff.getFirstName()+","+staff.getLastName()+","+staff.getPosition()+","+staff.getPay()+","+staff.getUserName()+","+staff.getPassword());
        }
    }catch(IOException e){
    e.printStackTrace();
}
}
    
}

