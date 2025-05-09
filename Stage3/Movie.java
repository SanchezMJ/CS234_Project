public class Movie {
	//defines instance variable
	private String title; //title of the movie that the staff can set. 
	private String runtime;
	private String rating;
	private Boolean is3D; //Extra information that the staff can set. 
	private String Synopsis; //Description of the movie. 
	private double cost; // double value for currency 

	//intializes variables for title, runtime, rating, boolean for is 3D, synopsis, and cost
	public Movie() {
		this.title = "";
		this.runtime = "";
		this.rating = "";
		this.is3D = false; //Initially set to false. 
		this.Synopsis = ""; //empty string till staff changes fields. 
		this.cost = 0.0; 
	}

	//assigns values to intialized variables
        public Movie(String t, String rt, String r, String s) {
		this.title = t;
		this.runtime = rt;
		this.rating = r;
		this.is3D = false; //Initially set to false. 
		this.Synopsis = s; //empty string till staff changes fields. 
		this.cost = 0.0; 
	}

	//gets movie information
	public void getMovieInfo() { //list of setters and getters methods. 
		
	}

	//gets movie title
	public String getMovieTitle() {
		return title;
	}

	//sets movie title
	public void setMovieTitle(String title){
		this.title=title;
	}

	//gets movie rating
	public String getRating() {
		return rating;
	}

	//sets movie rating
	public void setRating(String rating) {
		this.rating = rating; 
	}

	//gets movie run time
	public String getRuntime() {
		return runtime;
	}
	
	//sets movie run time
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	//gets boolean for if movie is 3D
	public boolean getIs3D() {
		return is3D;
	}

	//sets boolean for if movie is 3D
	public void setIs3D(boolean is3D) {
		this.is3D = is3D;
	}

	//gets movie synopsis
	public String getSynopsis() {
		return Synopsis; 
	}

	//sets movie synopsis
	public void setSynopsis(String Synopsis) {
		this.Synopsis = Synopsis;
	}

	//gets cost
	public double getCost() {
		return cost;
	}

	//sets cost
	public void setCost(double cost) {
		this.cost = cost;
	}

	//ovverides output to print in a particular format
	@Override
    public String toString() {
        return "Title: " + title +
               "\nRuntime: " + runtime +
               "\nRating: " + rating +
               "\n3D: " + (is3D ? "Yes" : "No") +
               "\nSynopsis: " + Synopsis;
	}
}
	

