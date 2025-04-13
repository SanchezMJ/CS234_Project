
import java.util.ArrayList;

/**
 *
 * @author jbock
 */
public class Showtimes {
    //defines instance variables
    private Movie title;
    private int time;
    private Screen screen;

    //intializes instance variables for title, time, and screen
    public Showtimes(){
    this.title=title;
    this.time=time;
    this.screen=screen;
}
    //assigns values for intialized instance variables
    public Showtimes(Movie title, int time, Screen screen){
    this.title=title;
    this.time=time;
    this.screen=screen;
}
    //sets titel
    public void setTitle(Movie title){
        this.title=title;
    }

    //gets title
    public String getTitle(){
        return title.getMovieTitle();
    }

    //sets time
    public void setTime(int time){
        this.time=time;
    }

    //gets time
    public int getTime(){
        return time;
    }

    //gets screen
    public Screen getScreen() {
        return screen;
    }

    //gets screen type
    public String getScreenType() {
        return screen.getType();
    }

    //gets seating from an array list
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
    public void seatsTaken (Cart cart, Showtimes show) {
        ArrayList<Seating>list = new ArrayList<>();
        ArrayList<String>seating = new ArrayList<>();
        Cart x = new Cart();
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

    //overrides output to print in a certain format
    @Override
    public String toString(){
        return "Title: "+title+"\nTime: "+time+"\nScreen: "+screen + "\n";
    }
    
}
