/**
 *
 * @author mjsanchez
 */
public class Seating {
    //essentially the seat name Ex. (A01)
    private String seat;
    private double seatCost;
    private String type;
    
    public Seating() {
        this.seat = seat;
        this.type = type;
        //Automatically assigns cost pending type.
        seatCost = 11.5;
        if (type == "imax") {
            this.seatCost = 20.0;
        } else {
            this.seatCost = 11.50;
        }   
    }
    
    public Seating(String s, String t) {
        seat = s;
        type = t;
        seatCost = 11.5;
        if (type == "imax") {
            this.seatCost = 20.0;
        } else {
            this.seatCost = 11.50;
        }   
    }
    
    //Returns seat desgination.
    public String getSeat() {
        return seat;
    }
    
    //Sets seat designation.
    public void setSeat(String seat) {
        this.seat = seat;
    }
    
    //Returns seat cost.
    public double getSeatCost() {
        return seatCost;
    }
    
    //sets seat cost.
    public void setSeatCost(double seatCost) {
        this.seatCost = seatCost;
    }
    
    //gets seat type.  Ex. Imax or not
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    public void remScreenSeats(String rem) {
        //seatSelection
    }
    
    public void addScreenSeats() {
        
    }
    
    
}
