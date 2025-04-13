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
    
}

