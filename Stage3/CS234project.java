
package cs234project;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mjsanchez
 */
public class CS234project {

public static Object MainMenu(HashSet<Customer> hashset, Membership mem, Authentication obauth, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth) {
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
                        staff = StaffMainMenu(hashset, mem, obauth, alist, objman, objauth);
                        return staff;
                    case 3:
                        System.out.println("Exiting");
                        sentinal = -1;
                        return "result";
                    default: 
                        System.out.println("Invalid choice. Please try again.");
                        //return null;
                }
            }
    return null;
}
    
public static Customer CustomerMainMenu(HashSet<Customer> hashset, Membership mem, Authentication obauth, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth) {
        Customer current = new Customer();
        boolean check = true;
        current = null;
        Scanner in = new Scanner(System.in);
        while(check) {
            System.out.println("========================");
            System.out.println("\tCustomer Menu\n1. Customer Login\n2. Register\n3. Login as Guest\n4. Exit");
            System.out.println("========================");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            in.nextLine();
            switch(choice){
                case 1: 
                    current = CustomerLogin(hashset, mem, obauth);
                    check = false;
                    break;
                case 2:
                    CustomerRegister(hashset, mem, obauth);
                    check = false;
                    break;
                case 3:
                    return current;
                case 4:
                    System.out.println("Exiting");
                    check = false;
                    MainMenu(hashset, mem, obauth, alist, objman, objauth);
                    return current;
                default: 
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    in.close();
    return current;
}

public static Staff StaffMainMenu(HashSet<Customer> hashset, Membership mem, Authentication obauth, ArrayList<Staff> alist, EmployeeManager objman, Authentication objauth) {
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
            System.out.println("\tStaff Menu\n1. Register New Staff\n2. Display Members List\n3. Display Employees\n4. Main Menu");
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
                    System.out.println("Return to Main Menu.");
                    MainMenu(hashset, mem, obauth, alist, objman, objauth);
                    break;
                default: 
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        in.close();
        return current;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Membership mem1 = new Membership();
        Cart cart1 = new Cart();
        Seating seats1 = new Seating();
        ArrayList<Seating> seats = cart1.getSeatSelection();
        Authentication authCust = new Authentication(mem1);
        Customer cur = new Customer();
        EmployeeManager manage = new EmployeeManager();
        Authentication authStaff = new Authentication(manage);
        Staff worker1 = new Staff("Jordan", "Bock", "Manager", 40.45, "jbock", "Whiskey");
        manage.addEmployee(worker1);
        Staff worker2 = new Staff("Giovanni", "Pernudi", "Manager", 40.45, "gpernudi", "Bourbon");
        manage.addEmployee(worker2);
        Staff worker3 = new Staff("Michael", "Sanchez", "Cashier", 18.45, "msanchez", "Scotch");
        manage.addEmployee(worker3);
        HashSet<Customer>newest = mem1.getMembers();
        ArrayList<Staff>staffList = manage.getListOfEmployees();
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
        Object current = MainMenu(newest, mem1, authCust, staffList, manage, authStaff);
        ShowtimeManager shows = new ShowtimeManager();
        ArrayList<Showtimes> showtimes = shows.getListOfTime();
        Screen screen1 = new Screen("Screen 1", "Regular");
        Screen screen2 = new Screen("Screen 2");
        Screen screen3 = new Screen("Screen 3");
        Screen screen4 = new Screen("Screen 4");
        Screen screen5 = new Screen("Screen 5", "imax");
        Movie m1 = new Movie("Batman", "1h 36m", "PG-13", "Batman battles the Joker in this...");
        Movie m2 = new Movie("Heat", "2h 50m", "R", "Master criminal Neil McMauley...");
        Showtimes st1 = new Showtimes(m1, 1930, screen1);
        shows.addShowTime(st1);
        Showtimes st2 = new Showtimes(m1, 2230, screen5);
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
