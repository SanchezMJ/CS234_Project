
package cs234project;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mjsanchez
 */
public class CS234project {

public static String MainMenu() {
    System.out.println("Welcome to GENERIC Movie Theater!");
        System.out.println("Please select an option below.");
        
//        int sentinal = 0;
//        while(sentinal >= 0) {
            System.out.println("========================");
            System.out.println("\tMain Menu\n1. Customer \n2. Staff\n3. Exit");
            System.out.println("========================");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int sentient = 1;
            int choice = in.nextInt();
            while(sentient >= 0){
                switch(choice){
                    case 1:
                        return "Customer";
                    case 2:
                        return "Staff";
                    case 3:
                        System.out.println("Exiting");
                        sentient = -1;
                        break;
                    default: 
                        System.out.println("Invalid choice. Please try again.");
                        return null;
                }
                return null;
            }
    return null;
}
    
public static Customer CustomerMainMenu(HashSet<Customer> hset, Membership objmem, Authentication objauth) {
        Customer current = new Customer();
        
//        int sentinal = 0;
//        while(sentinal >= 0) {
            System.out.println("========================");
            System.out.println("\tCustomer Menu\n1. Customer Login\n2. Register\n3. Login as Guest\n4. Exit");
            System.out.println("========================");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            switch(choice){
                case 1: 
                    current = CustomerLogin(hset, objmem, objauth);
                    return current;
                    //break;
                case 2:
                    CustomerRegister(hset, objmem, objauth);
                    break;
                case 3:
                    return current;
                case 4:
                    System.out.println("Exiting");
                    break;
                default: 
                    System.out.println("Invalid choice. Please try again.");
                    return null;
            }
            return null;
}

public static Staff StaffMainMenu(ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth) {
            Staff current = new Staff();
        
//        int sentinal = 0;
//        while(sentinal >= 0) {
            System.out.println("========================");
            System.out.println("\tStaff Menu\n1. Staff login\n2. Register Staff Member\n3. Exit");
            System.out.println("========================");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            switch(choice){
                case 1: 
                    current = StaffLogin(alist, objman, objauth);
                    return current;
                    //break;
                case 2:
                    StaffRegister(alist, objman, objauth);
                    break;
                case 3:
                    System.out.println("Exiting");
                    break;
                default: 
                    System.out.println("Invalid choice. Please try again.");
                    return null;
            }
            return null;
}
    
public static Customer CustomerLogin(HashSet<Customer> hset, Membership objmem, Authentication objauth) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter your phone number");
    long inputNum = scanner.nextLong();
    scanner.nextLine();
    System.out.println("Please enter your password.");
    String inputPass = scanner.nextLine();
    Customer current = objauth.AuthenticateCustomer(inputNum, inputPass);
    return current;
}

public static Staff StaffLogin(ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter your user name");
    String uname = scanner.nextLine();
    System.out.println("Please enter your password.");
    String inputPass = scanner.nextLine();
    Staff current = objauth.AuthenticateStaff(uname, inputPass);
    return current;
}

public static void CustomerRegister(HashSet<Customer> members, Membership member, Authentication authentication) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter your first name.");
    String fname = scanner.nextLine();
    System.out.println("Please enter your last name.");
    String lname = scanner.nextLine();
    System.out.println("Please enter your date of birth (mm/dd/yyyy)");
    String dob = scanner.nextLine();
    System.out.println("Please enter your phone number");
    long inputNum = scanner.nextLong();
    scanner.nextLine();
    System.out.println("Please enter your password.");
    String inputPass = scanner.nextLine();
    Customer x = new Customer(fname, lname, dob, inputNum, inputPass);
    member.addMembers(x);
    CustomerMainMenu(members, member, authentication);
}

public static void StaffRegister(ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter employee first name.");
    String fname = scanner.nextLine();
    System.out.println("Please enter employee last name.");
    String lname = scanner.nextLine();
    System.out.println("Please enter employee position.");
    String pos = scanner.nextLine();
    System.out.println("Please enter employee user name");
    String uname = scanner.nextLine();
    System.out.println("Please enter your password.");
    String inputPass = scanner.nextLine();
    System.out.println("Please enter employee pay rate.");
    double pr = scanner.nextDouble();
    scanner.nextLine();
    Staff x = new Staff(fname, lname, pos, pr, uname, inputPass);
    objman.addEmployee(x);
    StaffMainMenu(alist, objman, objauth);
}
public static Staff StaffMenu(ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter your user name.");
    String uname = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Please enter your password.");
    String inputPass = scanner.nextLine();
    Staff currStaff = objauth.AuthenticateStaff(uname, inputPass);
    return currStaff;
}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Membership mem1 = new Membership();
        Authentication authCust = new Authentication(mem1);
        Customer cur = new Customer();
        EmployeeManager manage = new EmployeeManager();
        Authentication authStaff = new Authentication(manage);
        Staff worker = new Staff("Jordan", "Bock", "Manager", 40.45, "jbock", "Whiskey");
        manage.addEmployee(worker);
        HashSet<Customer>newest = mem1.getMembers();
        ArrayList<Staff>staffList = manage.getListOfEmployees();
        //Customer c1 = new Customer("Michael", "Sanchez", "10/31/2000", 5758888888L, "Poop");
        //mem1.addMembers(c1);
        String choice = MainMenu();
        if (choice.equals("Staff")) {
            worker = StaffMainMenu(staffList, manage, authStaff);
        }
        if (choice.equals("Customer")) {
            cur = CustomerMainMenu(newest, mem1, authCust);
        }
        
        


//        mem1.addMembers(c1);
//        Customer c2 = new Customer("xyz", "Sanchez", "02/14/2000", 5757777777L, "Pooping");
//        mem1.addMembers(c2);
//        Customer c3 = new Customer("abc", "Sanchez", "07/04/2000", 5759999999L, "Pooped");
//        mem1.addMembers(c3);
//        Customer c4 = new Customer("hij", "Sanchez", "12/25/2000", 5756666666L, "Poops");
//        mem1.addMembers(c4);
//        Customer c5 = new Customer("Michael", "Sanchez", "10/31/2000", 5758888888L, "Poop");
//        mem1.addMembers(c5);
//        
        System.out.println(mem1.getMembers());
        System.out.println(manage.getListOfEmployees());
//        System.out.println("Please enter your phone number");
//        long inputNum = scanner.nextLong();
//        scanner.nextLine();
//        boolean c = mem1.isMember(inputNum);
//        System.out.println("Please enter your password.");
//        String inputPass = scanner.nextLine();
//        Customer current = auth.AuthenticateCustomer(inputNum, inputPass);       
        //cur.addPoints(100);
        //System.out.println(cur);

        boolean result;
        GiftCards card1 = new GiftCards(6401, "10/14/2025", 5000.00);
        card1.addGiftCard(card1);
        Payment Pay1 = new GiftCardPayment(100.00, 6401, "10/24/25");
        long x = Pay1.getGiftCardNum();
        result = card1.isGiftCard(x);
        //Pay1.paymentDetails();
        Screen s1 = new Screen("Screen 1", "imax");
        Screen s2 = new Screen("Screen 2");
        Seating s3 = new Seating("IA1", "imax");
        String s = s3.getSeat();
        s3.addSeatSelection(s);
        Seating s4 = new Seating("IA2", "imax");
        String ss = s4.getSeat();
        s3.addSeatSelection(ss);
        
    }
    
}
