/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


//import cs234project.Cart;
import java.util.ArrayList;

/**
 *
 * @author jbock
 */
//sets instance variables
public class Showtimes {
    private Movie title;
    private int time;
    private Screen screen;
    
    //intializes instance variables
    public Showtimes(){
    this.title = new Movie("Unknown", "0m", "NR", "No description");
    this.time = 0;
    this.screen = new Screen("Unknown Screen");
}
    //assigns variables to specific values
    public Showtimes(Movie title, int time, Screen screen){
    this.title=title;
    this.time=time;
    this.screen=screen;
}
    
    //sets movies title
    public void setTitle(Movie title){
        this.title=title;
    }
    
    //gets movie title
    public String getTitle(){
        return title.getMovieTitle();
    }
    
    //gets movie rating
    public String getRating(){
        return title.getRating();
    }
    
    //gets description of movie
    public String getDesc(){
        return title.getSynopsis();
    }
    
    //gets movie runt time
    public String getRuntime(){
        return title.getRuntime();
    }
    
    //sets movie run time
    public void setTime(int time){
        this.time=time;
    }
    
    //gets movie time
    public String getTime(){
        String movieTime = Integer.toString(time);
        return movieTime;
    }
    
    //gets screen number
    public Screen getScreen() {
        return screen;
    }
    
    //gets screen type
    public String getScreenType() {
        return screen.getType();
    }
    
    //gets seating
    public ArrayList<String> getShowSeating() {
        return screen.getSeating();
    }
    
    //displays seating
    public void displayShowSeating() {
        screen.displaySeating(screen);
    }
    
    /**
     * Method takes the arraylist of selected seats and replaces those
     * values with a "xxx" designation so users know they are taken and cant
     * request the same seat values.
     * @param cart uses object cart
     * @param show modifies the unique show object seating list.
     */
    
    //shows already selected seats
    public void seatsTaken (Cart cart, Showtimes show) {
        ArrayList<Seating>list = new ArrayList<>();
        ArrayList<String>seating = new ArrayList<>();
        list = cart.getSeatSelection();
        String current;
        seating = show.getShowSeating();
        for (Seating t:list) {
            current = t.getSeat();
            //System.out.println(current);
            for (int i = 0; i < seating.size(); i++) {
                if(seating.get(i).equals(current)) {
                    seating.set(i, "XXX");
                    break;
                }
            }
        }
    }
      
    //overrides output to print specific result
    @Override
    public String toString(){
        return "Title: " + title.getMovieTitle() +
       "\nTime: " + time +
       "\nScreen: " + screen.getName(); // if getName() exists
    }
    
}
