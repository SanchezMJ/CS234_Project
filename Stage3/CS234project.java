
package com.mycompany.cs234project;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mjsanchez
 */
public class CS234project {

    //Main Menu method for initial menu.
    public static Customer MainMenu(HashSet<Customer> hashset, Membership mem, Authentication obauth, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth,Inventory inventory) {
    System.out.println("Welcome to GENERIC Movie Theater!");
        System.out.println("Please select an option below.");
        Customer current = new Customer();
        Staff staff = new Staff();
        //String result = "";
        int sentinal = 0;
        while(sentinal <= 0) {
            System.out.println("========================");
            System.out.println("\tMain Menu\n1. Customer \n2. Staff\n3. Exit");
            System.out.println("========================");
            Scanner in = new Scanner(System.in);
            //in.nextLine();
            System.out.print("Enter your choice: ");
            //int sentinal = 1;
            int choice = in.nextInt();
                switch(choice){
                    case 1:
                        current = CustomerMainMenu(hashset, mem, obauth, alist, objman, objauth);
                        return current;
                    case 2:
                        staff = StaffMainMenu(hashset, mem, obauth, alist, objman, objauth,inventory);
                        break;
                    case 3:
                        System.out.println("Exiting");
                        return current;
                    default: 
                        System.out.println("Invalid choice. Please try again.");
                        //return null;
                }
            }
    return null;
}
    
public static Customer CustomerMainMenu(HashSet<Customer> hashset, Membership mem, Authentication obauth, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth) {
        Customer current = new Customer();
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("========================");
            System.out.println("\tCustomer Menu\n1. Customer Login\n2. Customer Registration\n3. Login as Guest\n4. Exit");
            System.out.println("========================");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            in.nextLine();
            switch(choice){
                case 1: 
                    current = CustomerLogin(hashset, mem, obauth);
                    //check = false;
                    return current;
                case 2:
                    CustomerRegister(hashset, mem, obauth);
                    break;
                case 3:
                    return current;
                case 4:
                    System.out.println("Exiting");
                    return null;
                default: 
                    System.out.println("Invalid choice. Please try again.");
            }
        }
}

public static Staff StaffMainMenu(HashSet<Customer> hashset, Membership mem, Authentication obauth, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth,Inventory inventory) {
        Staff current = new Staff();
        boolean check = true;
        int sentinal = 0;
        current = null;
        Scanner in = new Scanner(System.in);
        while(sentinal >=0 ) {
            while (current == null) {
                current = StaffLogin(alist, objman, objauth);
                if (current == null) {
                    System.out.println("User name or password is invalid, please try again.");
                    System.out.println("Press 1 to try again.  Press 2 to return to the Main Menu.");
                    int choice = in.nextInt();
                    if (choice == 2){
                    }
                }
            }
            String pos = current.getPosition();
            System.out.println("========================");
            System.out.println("\tStaff Menu\n1. Register New Staff\n2. Display Members List\n3. Display Employees\n4. Inventory\n5. Main Menu");
            System.out.println("========================");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            switch(choice){
                case 1: 
                    if (pos.equalsIgnoreCase("Manager")) {
                        StaffRegister(alist, objman, objauth);
                        break;
                    } else {
                        System.out.println("ACCESS DENIED");
                        break;
                    }
                case 2:
                    mem.getMember();
                    break;
                case 3:
                    objman.showEmployees();
                    break;
                case 4:
                    InventoryMenu(inventory);
                case 5:
                    System.out.println("Return to Main Menu.");
                    MainMenu(hashset, mem, obauth, alist, objman, objauth,inventory);
                    break;
                default: 
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        in.close();
        return current;
}
    
public static Customer CustomerLogin(HashSet<Customer> hset, Membership objmem, Authentication objauth) {
    //Need to add check for data input
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
    System.out.println("Please enter your user name.");
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
    //CustomerMainMenu(members, member, authentication);
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
        //StaffMainMenu(alist, objman, objauth);
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

public static void TransactionMenu(Inventory inventory, ArrayList<Concession> prod, Cart cart, ArrayList<Showtimes> shows) {
        double totalAmount=cart.getTotal();
        System.out.println("total: "+totalAmount);
        int sentinal = 0;
        while(sentinal >= 0) {
            System.out.println("========================");
            System.out.println("\tTransaction Menu\n1. Buy Tickets\n2. Concessions\n3. Payment\n4. Exit");
            System.out.println("========================");
            Scanner in = new Scanner(System.in);
            //in.nextLine();
            System.out.print("Enter your choice: ");
            //int sentinal = 1;
            int choice = in.nextInt();
                switch(choice){
                    case 1:
                        MovieSelection(inventory, cart, shows);
                        cart.getTotal();
                        break;
                    case 2:
                        AddProducts(inventory, prod, cart);
                        cart.getTotal();
                        break;
                    case 3:
                        totalAmount=cart.getTotal();
                        PaymentMenu(totalAmount,cart);
                        break;
                    case 4:
                        System.out.println("Exiting");
                        sentinal = -1;
                        break;
                    default: 
                        System.out.println("Invalid choice. Please try again.");
                        //return null;
                }
        }
}

public static void AddProducts(Inventory inventory, ArrayList<Concession> prod, Cart cart) {
        for (int i = 0; i < prod.size(); i++) {
            int num = i + 1;
            System.out.println(num + ". " + prod.get(i));
        }
        int sentinal = 0;
        System.out.println();
        System.out.print("Enter product selection, enter 0 when finished.");
        System.out.println();
        while(sentinal == 0) {
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            if (choice != 0) {
                int n = choice - 1;
                cart.addProduct(prod.get(n));
            } else {
                sentinal = -1;
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
    int choice = in.nextInt();
    int n = choice - 1;
    currentShow = shows.get(n);
    currentShow.displayShowSeating();
    String t = currentShow.getScreenType();
    System.out.println();
    System.out.println("Choose seat(s). Enter 'f' when finished.");
        while (!seats.equals(check)) { 
            in = new Scanner(System.in);
            seats = in.nextLine();
            seating = currentShow.getShowSeating();
        //System.out.println(seating.get(1));

            for (int i = 0; i < seating.size(); i++) {
                if (seats.equals(seating.get(i))) {
                    Seating seat = new Seating(seats, t);
                    cart.addSeat(seat);
                }
            }
            currentShow.seatsTaken(cart, currentShow);
        }
}

    public static void PaymentMenu(double totalAmount, Cart cart){
         int sentinel = 0;
        while(sentinel >= 0) {
            System.out.println("========================");
            System.out.println("\tPayment Menu\n1. Cash\n2. Credit Card\n3. Gift Card\n4. Exit");
            System.out.println("========================");
            System.out.println("Total: "+totalAmount);
             Scanner in = new Scanner(System.in);
            //in.nextLine();
            System.out.print("Enter your choice: ");
            //int sentinal = 1;
            int choice = in.nextInt();
                switch(choice){
                    case 1:
                        System.out.print("Cash Amount: ");
                        double cashAmount=in.nextDouble();
                        if(cashAmount>=totalAmount){
                            CashPayment cashPayment=new CashPayment(totalAmount,cashAmount);
                            cashPayment.paymentDetails();
                            cart.emptyCart();
                            sentinel=-1;
                        }else{
                            System.out.println("Insufficient funds.");
                        }
                        break;
                   /** case 2:
                        CreditCardPayment();
                        break;
                    case 3:
                        GiftCardPayment();
                        break;
                    case 4:
                        System.out.println("Exiting");
                        sentinal = -1;
                        break;
                    default: 
                        System.out.println("Invalid choice. Please try again.");
                        //return null;
                        */}
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
        Scanner scanner = new Scanner(System.in);
        Membership mem1 = new Membership();
        Inventory inventory = new Inventory();
        Cart cart1 = new Cart();
        Seating seats1 = new Seating();
        ArrayList<Seating> seats = cart1.getSeatSelection();
        Authentication authCust = new Authentication(mem1);
        Customer cur = new Customer();
        EmployeeManager manage = new EmployeeManager();
        Authentication authStaff = new Authentication(manage);
        
        //Generate Workers
        Staff worker1 = new Staff("Jordan", "Bock", "Manager", 40.45, "jbock", "Whiskey");
        manage.addEmployee(worker1);
        Staff worker2 = new Staff("Giovanni", "Pernudi", "Manager", 40.45, "gpernudi", "Bourbon");
        manage.addEmployee(worker2);
        Staff worker3 = new Staff("Michael", "Sanchez", "Cashier", 18.45, "msanchez", "Scotch");
        manage.addEmployee(worker3);
        
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
        
        //Calls Main Menu and returns current customer.
        int sentinal = 0;
        while (sentinal >= 0) {
            cur = MainMenu(newest, mem1, authCust, staffList, manage, authStaff,inventory);
            if(cur!=null){
            TransactionMenu(inventory, products, cart1, showtimes);
            cart1.getCart();
            System.out.printf("Total: $%.2f\n", cart1.getTotal());
            System.out.println();
            }
        }
        
        
        



        /**
         * Testing for adding seats and verifying that seats are xxx out from the seat
         * array for that specific showtime.
         */
        //shows.addShowTime(st2);
        //shows.displaySeating(st1);
        ArrayList<String>seating = st1.getShowSeating();
        //st1.displayShowSeating();
        st1.getScreen();
        double cost = st1.getScreen().getSeatCost();
        String type = st1.getScreenType();
        Seating seat1 = new Seating("A01", type);
        Seating seat2 = new Seating("A02", type);
        Seating seat3 = new Seating("C04", type);
        Seating seat4 = new Seating("C05", type);
        cart1.addSeat(seat1);
        cart1.addSeat(seat2);
        cart1.addSeat(seat3);
        cart1.addSeat(seat4);
        
        st1.seatsTaken(cart1, st1);
        st1.displayShowSeating();
        cart1.getCart();
        System.out.println("Total seat Cost: $" + cart1.getTotal());
        
        //st1.getSeating();
        


//        mem1.addMembers(c1);

//        
//        System.out.println(mem1.getMembers());
//        System.out.println(manage.getListOfEmployees());
//        System.out.println("Please enter your phone number");
//        long inputNum = scanner.nextLong();
//        scanner.nextLine();
//        boolean c = mem1.isMember(inputNum);
//        System.out.println("Please enter your password.");
//        String inputPass = scanner.nextLine();
//        Customer current = auth.AuthenticateCustomer(inputNum, inputPass);       
        cur.addPoints(100);
        System.out.println(cur);

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
        //s3.addSeatSelection(s);
        Seating s4 = new Seating("IA2", "imax");
        String ss = s4.getSeat();
        //s3.addSeatSelection(ss);
        
        //System.out.println(s1);
        //System.out.println(s2);
        //s1.displaySeating(s1);
        //s2.displaySeating(s2);
//        ArrayList<String>seats = s1.getSeatSelection();
//        ArrayList<String>s2seats = s2.getSeatSelection();
//        s1.addSeat("A01");
//        s1.addSeat("A02");
//        s1.addSeat("E06");
//        s1.addSeat("E07");
//        s2.addSeat("D13");
//        s2.addSeat("D14");
//        s2.addSeat("F05");
//        s2.addSeat("F06");
//        s1.seatsTaken(seats);
//        s1.displaySeating(s1);
//        s2.seatsTaken(s2seats);
//        s2.displaySeating(s2);
        
    }
    
}

   
