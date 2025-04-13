
package com.mycompany.cs234project;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Michael Sanchez and Jordan Bock
 */
public class Main {

    //Main Menu method for initial menu.
public static void MainMenu(Customer customer, Staff staff, HashSet<Customer> hashset, Membership mem, Authentication obauth, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth, Inventory inventory, ArrayList<Concession> prod, Cart cart, ArrayList<Showtimes> shows) {
    System.out.println("Welcome to GENERIC Movie Theater!");
        System.out.println("Please select an option below.");
        int sentinal = 0;
        int choice = 0;
        while(sentinal >= 0) {
            System.out.println("========================");
            System.out.println("\tMAIN MENU\n1. Customer \n2. Staff\n3. Exit");
            System.out.println("========================");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
                switch(choice){
                    case 1:
                        CustomerMainMenu(customer, staff, hashset, mem, obauth, alist, objman, objauth, inventory, prod, cart, shows);
                        break;
                    case 2:
                        StaffMainMenu(customer, staff, hashset, mem, obauth, alist, objman, objauth,inventory, prod, cart, shows);
                        break;
                    case 3:
                        System.out.println("Exiting");
                        sentinal = -1;
                        break;
                    default: 
                        System.out.println("Invalid choice. Please try again.");
                }
        }
}

//CustomerMainMenu method.  
public static void CustomerMainMenu(Customer customer, Staff staff, HashSet<Customer> hashset, Membership mem, Authentication obauth, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth, Inventory inventory, ArrayList<Concession> prod, Cart cart, ArrayList<Showtimes> shows) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        int sentinel = 0;
            System.out.println("========================");
            System.out.println("\tCUSTOMER MENU\n1. Customer Login\n2. Customer Registration\n3. Login as Guest\n4. Main Menu");
            System.out.println("========================");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            in.nextLine();
            if (choice ==1){
                    //Allows customer to loin and assigns the return value to customer.
                    customer = CustomerLogin(customer, hashset, mem, obauth);
                    //Once customer is assigned, navigates to TransactionMenu()
                    TransactionMenu(customer, staff, hashset, mem, obauth, alist, objman, objauth, inventory, prod, cart, shows);
            }else if(choice == 2) {
                    CustomerRegister(hashset, mem, obauth);
            }else if (choice == 3) {
                    TransactionMenu(customer, staff, hashset, mem, obauth, alist, objman, objauth, inventory, prod, cart, shows);
            }else if (choice == 4) {
                    System.out.println("Returning to Main Menu");
                    //sentinel = -1;
            }
}

public static void StaffMainMenu(Customer customer, Staff staff, HashSet<Customer> hashset, Membership mem, Authentication obauth, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth,Inventory inventory, ArrayList<Concession> prod, Cart cart, ArrayList<Showtimes> shows) {
        int sentinal = 0;
        int choice = 0;
        Scanner in = new Scanner(System.in);
        while(sentinal >=0 ) {
            //Enters while loop when staff object is set to default(null)
            while (staff==null || staff.getFirstName() == null) {
                //staff object is assigned the return value of StaffLogin method.
                staff = StaffLogin(staff, alist, objman, objauth);
                //if no valid user is returned, prompt for correct credentials again.
                if (staff==null || staff.getFirstName() == null) {
                    System.out.println("User name or password is invalid, please try again.");
                    System.out.println("Press 1 to try again.  Press 2 to return to the Main Menu.");
                    choice = in.nextInt();
                    //If user can not provide the right credentials, this option allows them to return to the main menu.
                    if (choice == 2){
                        MainMenu(customer, staff, hashset, mem, obauth, alist, objman, objauth,inventory, prod, cart, shows);
                        return;
                    }
                }
            }
            //position is used to access certain staff menu items.
            String pos = staff.getPosition();
            System.out.println("========================");
            System.out.println("\tSTAFF MENU\n1. Register New Staff\n2. Remove Staff\n3. Display Members List\n4. Display Employees\n5. Inventory\n6. Main Menu");
            System.out.println("========================");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            switch(choice){
                case 1: 
                    //Require Manager level access to register new staff.
                    if (pos.equalsIgnoreCase("Manager")) {
                        StaffRegister(alist, objman, objauth);
                        break;
                    } else {
                        System.out.println("ACCESS DENIED");
                        break;
                    }
                     case 2:
                         //require manager level access to remove employees
                    if (pos.equalsIgnoreCase("Manager")) {
                    in.nextLine();
                        System.out.println("Please enter username of employee to remove:");
                        String name=in.nextLine();
                        Staff toRemove=null;
                        for(Staff emp: objman.getListOfEmployees()){
                            if(emp.getUserName().equalsIgnoreCase(name)){
                                toRemove=emp;
                                break;
                            }
                        }
                        if(toRemove!=null){
                            objman.removeEmployee(toRemove);
                            System.out.println("Employee removed.");
                        }else{
                            System.out.println("Employee not found.");
                        }
                        break;
                    }else{ System.out.println("ACCESS DENIED");
                        break;
                    } 
                case 3:
                    mem.getMember();
                    break;
                case 4:
                    objman.showEmployees();
                    break;
                case 5:
                    InventoryMenu(inventory);
                    break;
                case 6:
                    System.out.println("Return to Main Menu.");
                    sentinal = -1;
                    break;
                default: 
                    System.out.println("Invalid choice. Please try again.");
            }
        }
}
           
public static Customer CustomerLogin(Customer customer, HashSet<Customer> hset, Membership objmem, Authentication objauth) {
    //Need to add check for data input
    Scanner scanner = new Scanner(System.in);
    long inputNum = 0;
    System.out.println("Please enter your phone number");
    String input = scanner.nextLine();
    //while loop checks for 10 digits of input from user for phone number and if not found enters loop.
    while (!input.matches("\\d{10}")) {
        System.out.println("Invalid phone number entry.  Please try again.");
        System.out.println("Please enter your phone number");
        input = scanner.nextLine();
    }
    //Casts the string input to long value.
    inputNum = Long.parseLong(input);
    System.out.println("Please enter your password.");
    String inputPass = scanner.nextLine();
    //customer is assigned to the return value of AuthenticateCustoner method.
    customer = objauth.AuthenticateCustomer(inputNum, inputPass);
    return customer;
}

public static Staff StaffLogin(Staff staff, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter your user name.");
    String uname = scanner.nextLine();
    System.out.println("Please enter your password.");
    String inputPass = scanner.nextLine();
    //staff is assigned the return value of AuthenticateStaff method
    staff = objauth.AuthenticateStaff(uname, inputPass);
    return staff;
}

public static void CustomerRegister(HashSet<Customer> members, Membership member, Authentication authentication) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter your first name.");
    String fname = scanner.nextLine();
    System.out.println("Please enter your last name.");
    String lname = scanner.nextLine();
    System.out.println("Please enter your date of birth (mm/dd/yyyy)");
    String dob = scanner.nextLine();
    long inputNum = 0;
    while(true){
    try{
        System.out.println("Please enter your phone number");
        inputNum = scanner.nextLong();
        if(inputNum>=1000000000L&&inputNum<=9999999999L){
            break;
        }else{
            System.out.println("Incorrect number of digits. Please try again.");
        }
    }catch(InputMismatchException e){
        System.out.println("Invalid input.");
        scanner.next();
    }
    scanner.nextLine();
}
    scanner.nextLine();
    System.out.println("Please enter your password.");
    String inputPass = scanner.nextLine();
    Customer x = new Customer(fname, lname, dob, inputNum, inputPass);
    member.addMembers(x);
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
}

public static void StaffMenu(ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter your user name.");
    String uname = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Please enter your password.");
    String inputPass = scanner.nextLine();
    //Authenticates user
    objauth.AuthenticateStaff(uname, inputPass);
}

public static void TransactionMenu(Customer customer, Staff staff, HashSet<Customer> hashset, Membership mem, Authentication obauth, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth, Inventory inventory, ArrayList<Concession> prod, Cart cart, ArrayList<Showtimes> shows) {
        //Changed this to only a definition vs inititalization as it was printing zero's when first called.
        double totalAmount;
        int choice = 0;
        int sentinel = 0;
        while(sentinel >= 0) {
            System.out.println("========================");
            System.out.println("\tTRANSACTION MENU\n1. Buy Tickets\n2. Concessions\n3. Payment\n4. Main Menu");
            System.out.println("========================");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            if (choice == 1) {
                MovieSelection(inventory, cart, shows);
                cart.getTotal();
            }else if (choice == 2) {
                AddProducts(inventory, prod, cart);
                cart.getTotal();
            }else if (choice == 3) {
                totalAmount=cart.getTotal();
                PaymentMenu(customer, staff, hashset, mem, obauth, alist, objman, objauth,inventory, prod, cart, shows, totalAmount);
            }else if (choice == 4) {
                System.out.println("Returning to Main Menu.");
                sentinel = -1;
            }
        }
}

//Method prints out a list of products that the user can select to add to the cart.
public static void AddProducts(Inventory inventory, ArrayList<Concession> prod, Cart cart) {
        //Prints list of products
        for (int i = 0; i < prod.size(); i++) {
            int num = i + 1;
            System.out.println(num + ". " + prod.get(i));
        }
        int sentinal = 0;
        int size = prod.size();
        int useSize = size + 1;
        System.out.println();
        System.out.print("Enter product selection, enter 0 when finished.");
        System.out.println();
        while(sentinal == 0) {
            Scanner in = new Scanner(System.in);
            //Checks to ensure an integer is entered.
            while(!in.hasNextInt()){
                System.out.println("Please enter an integer.");
                in.next();
            }
            int choice = in.nextInt();
            if (choice >= 1 && choice < prod.size()) {
                int n = choice - 1;
                cart.addProduct(prod.get(n));
            }else if (choice == 0) {
                sentinal = -1;
            }else if (choice > prod.size()) {
                System.out.println("Invalid Selection");
            }
        }
}

public static void MovieSelection(Inventory inventory, Cart cart, ArrayList<Showtimes> shows) {
    System.out.println();
    Showtimes currentShow = new Showtimes();
    ArrayList<String> seating = new ArrayList<>();
    for (int i = 0; i < shows.size(); i++) {
            int num = i + 1;
            System.out.println(num + ". " + shows.get(i));
    }
    String seats = "";
    String check = "f";
    System.out.println();
    System.out.println("Enter Movie selection, enter 0 when finished.");
    Scanner in = new Scanner(System.in);
    int choice; 
    String input=in.nextLine().trim();
    if(!input.matches("\\d+")){
        System.out.println("Invalid input. Returning to menu.");
        return;
    }
    choice=Integer.parseInt(input);
    if(choice==0){
        return;
    }
    int n=choice-1;
    if(n<0||n>=shows.size()){
        System.out.println("Invalid selection.");
        return;
    }
    currentShow = shows.get(n);
    currentShow.displayShowSeating();
    String t = currentShow.getScreenType();
    System.out.println();
    System.out.println("Choose seat(s). Enter 'f' when finished.");
        while (!seats.equalsIgnoreCase(check)) {
            in = new Scanner(System.in);
            seats = in.nextLine();
            seating = currentShow.getShowSeating();

            for (int i = 0; i < seating.size(); i++) {
                if (seats.equals(seating.get(i))) {
                    Seating seat = new Seating(seats, t);
                    cart.addSeat(seat);
                }
            }
            currentShow.seatsTaken(cart, currentShow);
        }
    }

public static void PaymentMenu(Customer customer, Staff staff, HashSet<Customer> hashset, Membership mem, Authentication obauth, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth, Inventory inventory, ArrayList<Concession> prod, Cart cart, ArrayList<Showtimes> shows, double totalAmount) {
    int sentinel = 0;
    int choice = 0;
    String check = customer.getFirstName();
    Payment pay = new Payment();
    double outstandingBalance = 0;
    ArrayList<Seating> s = new ArrayList<>();
    while (sentinel >= 0) {
        prod = cart.showProducts();
        s = cart.getSeatSelection();
        if (prod.isEmpty() && s.isEmpty()) {
            System.out.println();
            System.out.println("CART IS EMPTY!");
            break;
        }
            System.out.println();
            cart.getCart();
            System.out.println("----------------------");
            System.out.printf("Total: $%.2f\n", cart.getTotal());
            System.out.println();
            System.out.println("========================");
            System.out.println("\tPAYMENT MENU\n1. Cash\n2. Credit Card\n3. Gift Card\n4. Exit/Cancel Purchase");
            System.out.println("========================");
            Scanner in = new Scanner(System.in);
            System.out.print("Please select your payment method. ");
            while (!in.hasNextInt()) {
                System.out.println("Please enter an integer.");
                in.next();
            }
            choice = in.nextInt();
            if (choice == 1) {
                System.out.print("Cash Amount: ");
                double cashAmount = in.nextDouble();
                if (cashAmount >= totalAmount) {
                    Payment cashPayment = new CashPayment(totalAmount, cashAmount);
                    cashPayment.paymentDetails();
                    cashPayment.addPayment(cashPayment);
                    double change = cashAmount - totalAmount;
                    System.out.printf("Change Due: $%.2f\n", change);
                    System.out.println("TRANSACTION COMPLETE. THANK YOU!");
                    System.out.println();
                    if(!check.equals("Guest")) {
                        customer.addPoints(totalAmount);
                        System.out.println("*** " + customer.getFirstName() + " just earned " + customer.getPoints() + " points! ***");
                        System.out.println();
                    }
                    cart.emptyCart();
                    sentinel = -1;
                } else {
                    outstandingBalance = totalAmount - cashAmount;
                    System.out.printf("Amount remaining: $%.2f\n", outstandingBalance);
                    totalAmount = outstandingBalance;
                    customer.addPoints(cashAmount);
                    if(!check.equals("guest")) {
                        customer.addPoints(totalAmount);
                        System.out.println("*** " + customer.getFirstName() + " just earned " + customer.getPoints() + " points! ***");
                        System.out.println();
                    }
                    cart.setTotal(totalAmount);
                }
            } else if (choice == 2) {
                System.out.println();
                System.out.printf("Amount Due: $%.2f\n", totalAmount);
                System.out.println("Enter the first name on the account.");
                in.nextLine();
                String fname = in.nextLine();
                System.out.println("Enter the Last name on the account.");
                String lname = in.nextLine();
                System.out.println("Enter the credit card number.");
                String ccNum = in.nextLine();
                System.out.println("Enter the expiration date for the credit card.");
                String expDate = in.nextLine();
                System.out.println("Enter the security code.");
                int secCode = in.nextInt();
                Payment creditPayment = new CreditCardPayment(totalAmount, fname, lname, ccNum, expDate, secCode);
                creditPayment.addPayment(creditPayment);
                creditPayment.paymentDetails();
                System.out.println("TRANSACTION COMPLETE. THANK YOU!");
                System.out.println();
                if(!check.equals("Guest")) {
                        customer.addPoints(totalAmount);
                        System.out.println("*** " + customer.getFirstName() + " just earned " + customer.getPoints() + " points! ***");
                        System.out.println();
                }
                cart.emptyCart();
                sentinel = -1;
                //MainMenu(customer, staff, hashset, mem, obauth, alist, objman, objauth,inventory, prod, cart, shows);
            } else if (choice == 3) {
                System.out.println();
                System.out.printf("Amount Due: $%.2f\n", totalAmount);
                System.out.println("Enter the gift card number.");
                in.nextLine();
                String gcNum = in.nextLine();
                System.out.println("Enter the expiration date for the credit card.");
                String xpDate = in.nextLine();
                System.out.println("Please enter giftcard payment amount: ");
                double giftCardAmount = in.nextDouble();
                if (giftCardAmount >= totalAmount) {
                    Payment gcPayment = new GiftCardPayment(totalAmount, gcNum, xpDate);
                    gcPayment.addPayment(gcPayment);
                    gcPayment.paymentDetails();
                    System.out.println("TRANSACTION COMPLETE. THANK YOU!");
                    System.out.println();
                    if(!check.equals("Guest")) {
                        customer.addPoints(totalAmount);
                        System.out.println("*** " + customer.getFirstName() + " just earned " + customer.getPoints() + " points! ***");
                        System.out.println();
                    }
                    cart.emptyCart();
                    sentinel = -1;
                } else {
                    double remainingBalance = totalAmount - giftCardAmount;
                    Payment gcPayment = new GiftCardPayment(giftCardAmount, gcNum, xpDate);
                    gcPayment.addPayment(gcPayment);
                    gcPayment.paymentDetails();
                    System.out.printf("Amount remaining: $%.2f\n", remainingBalance);
                    if(!check.equals("Guest")) {
                        customer.addPoints(totalAmount);
                        System.out.println("*** " + customer.getFirstName() + " just earned " + customer.getPoints() + " points! ***");
                        System.out.println();
                    }
                    cart.setTotal(totalAmount = remainingBalance);
                }
            }else if (choice >= 4) {
                System.out.println("Exiting.  Cart will be emptied");
                cart.emptyCart();
                    sentinel = -1;
            }
        }
    }

public static void InventoryMenu(Inventory inventory){
         int sentinel = 0;
        while(sentinel >= 0) {
            System.out.println("========================");
            System.out.println("\tInventory Menu\n1. Show Inventory\n2. Add to Inventory\n3. Remove Inventory\n4. Exit");
            System.out.println("========================");
             Scanner in = new Scanner(System.in);
            //in.nextLine();
            System.out.print("Enter your choice: ");
            //int sentinal = 1;
            int choice = in.nextInt();
                switch(choice){
                    case 1:
                        inventory.showAllProducts();
                        break;
                    case 2:
                        in.nextLine();
                        System.out.print("Enter product name: ");
                        String name=in.nextLine();//
                        System.out.print("Enter product price: ");

                        while(!in.hasNextDouble()){
                            System.out.println("Please enter an price.");
                            in.next();
                        }
                        double price=in.nextDouble();
                        in.nextLine();
                        System.out.println("Please enter number of units: ");
                        int totalStock=in.nextInt();
                        Concession newProduct=new Concession(name, price,totalStock);
                        inventory.addProduct(newProduct);
                        System.out.println("Successfully added to inventory.");
                        break;
                    case 3:
                        in.nextLine();
                        System.out.println("Please enter item to remove from inventory:");
                        name=in.nextLine();
                        Concession toRemove=null;
                        for(Concession c: inventory.getProductList()){
                            if(c.getProduct().equalsIgnoreCase(name)){
                                toRemove=c;
                                break;
                            }
                        }
                        if(toRemove!=null){
                            inventory.removeProduct(toRemove);
                            System.out.println("Product removed.");
                        }else{
                            System.out.println("Product not found.");
                        }
                        break;
                    case 4:
                        System.out.println("Exiting");
                        sentinel = -1;
                        break;
                    default: 
                        System.out.println("Invalid choice. Please try again.");
                        //return null;
                }
        }
    }

public static void main(String[] args) {
        //Generate generic objects.
        Membership mem1 = new Membership();
        Inventory inventory = new Inventory();
        Cart cart1 = new Cart();
        Authentication authCust = new Authentication(mem1);
        Customer current = new Customer();
        Staff currentStaff = new Staff();
        EmployeeManager manage = new EmployeeManager();
        Authentication authStaff = new Authentication(manage);
        
        //Generate Workers
        Staff worker1 = new Staff("Jordan", "Bock", "Manager", 40.45, "jbock", "Whiskey");
        manage.addEmployee(worker1);
        Staff worker2 = new Staff("Giovanni", "Pernudi", "Manager", 40.45, "gpernudi", "Bourbon");
        manage.addEmployee(worker2);
        Staff worker3 = new Staff("Michael", "Sanchez", "Cashier", 18.45, "msanchez", "Scotch");
        manage.addEmployee(worker3);
        
        //Initialize lists
        HashSet<Customer>newest = mem1.getMembers();
        ArrayList<Staff>staffList = manage.getListOfEmployees();
        ArrayList<Concession> products = inventory.getProductList();
        
        //Generate Customers
        Customer c1 = new Customer("Mickey", "Mouse", "10/31/2000", 5758888888L, "Poop");
        mem1.addMembers(c1);
        Customer c2 = new Customer("Donald", "Duck", "02/14/2000", 5757777777L, "Pooping");
        mem1.addMembers(c2);
        Customer c3 = new Customer("Clarabelle", "Cow", "07/04/2000", 5759999999L, "Pooped");
        mem1.addMembers(c3);
        Customer c4 = new Customer("Minnie", "Mouse", "12/25/2000", 5756666666L, "Poops");
        mem1.addMembers(c4);
        Customer c5 = new Customer("Puzzle", "Pete", "10/31/2000", 5758888888L, "Poop");
        mem1.addMembers(c5);
        
        //Generates Screens
        ShowtimeManager shows = new ShowtimeManager();
        ArrayList<Showtimes> showtimes = shows.getListOfTime();
        Screen screen1 = new Screen("Screen 1", "Regular");
        Screen screen2 = new Screen("Screen 2");
        Screen screen3 = new Screen("Screen 3");
        Screen screen4 = new Screen("Screen 4");
        Screen screen5 = new Screen("Screen 5", "imax");
        
        //Generate Movie objects
        Movie m1 = new Movie("Batman", "1h 36m", "PG-13", "Batman battles the Joker in this...");
        Movie m2 = new Movie("Heat", "2h 50m", "R", "Master criminal Neil McMauley...");
        
        //Adds showtimes
        Showtimes st1 = new Showtimes(m1, 1930, screen1);
        shows.addShowTime(st1);
        Showtimes st2 = new Showtimes(m2, 2230, screen5);
        shows.addShowTime(st2);
        
        //generate products for concession and add them to productList in inventory
        Concession popcorn = new Concession("Popcorn", 5.00,5);
        inventory.addProduct(popcorn);
        Concession soda = new Concession("Soda", 3.00,6);
        inventory.addProduct(soda);
        Concession candy = new Concession("Candy", 2.00,7);
        inventory.addProduct(candy);
        
        MainMenu(current, currentStaff, newest, mem1, authCust, staffList, manage, authStaff,inventory, products, cart1, showtimes);
        
    }
    
}

   
