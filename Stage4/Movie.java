

// package group_Project;

public class Movie {
	private String title; //title of the movie that the staff can set. 
	private String runtime;
	private String rating;
	private Boolean is3D; //Extra information that the staff can set. 
	private String Synopsis; //Description of the movie. 
	private double cost; // double value for currency 
	
	public Movie() {
		this.title = "";
		this.runtime = "";
		this.rating = "";
		this.is3D = false; //Initially set to false. 
		this.Synopsis = ""; //empty string till staff changes fields. 
		this.cost = 0.0; 
	}
        
        public Movie(String t, String rt, String r, String s) {
		this.title = t;
		this.runtime = rt;
		this.rating = r;
		this.is3D = false; //Initially set to false. 
		this.Synopsis = s; //empty string till staff changes fields. 
		this.cost = 0.0; 
	}
	
	public void getMovieInfo() { //list of setters and getters methods. 
		
	}
	
	public String getMovieTitle() {
		return title;
	}

	public void setMovieTitle(String title){
		this.title=title;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating; 
	}
	
	public String getRuntime() {
		return runtime;
	}
	
	
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	
	public boolean getIs3D() {
		return is3D;
	}
	
	public void setIs3D(boolean is3D) {
		this.is3D = is3D;
	}
	
	public String getSynopsis() {
		return Synopsis; 
	}
	
	public void setSynopsis(String Synopsis) {
		this.Synopsis = Synopsis;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
    public String toString() {
        return "Title: " + title +
               "\nRuntime: " + runtime +
               "\nRating: " + rating +
               "\n3D: " + (is3D ? "Yes" : "No") +
               "\nSynopsis: " + Synopsis;
	}
}
	

