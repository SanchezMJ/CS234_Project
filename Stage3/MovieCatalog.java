/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import java.util.ArrayList;

/**
 *
 * @author jbock
 */
//manages a list of films
public class MovieCatalog {
     private ArrayList<Movie>listOfMovies;
    
     //intialises a list of films
    public MovieCatalog(){
    this.listOfMovies=new ArrayList<>();
    }
    
    //adds a film to the list
    public void addFilm(Movie newmovie){
        listOfMovies.add(newmovie);
        
    }
    
    //removes a film from the list if it exists
    public void removeFilm(String title){
        Movie toBeRemoved=findMovie(title);
        if(toBeRemoved!=null){
            listOfMovies.remove(toBeRemoved);
            System.out.println("Film "+title+" has been removed.");
        }else{
            System.out.println("Unable to remove.");
        }
    }
    
    //displays the list of movies
    public void displayMovies(){
        if(listOfMovies.isEmpty()){
            System.out.println("List of movies is empty.");
        }else{
        for (Movie movie : listOfMovies){
            System.out.println(movie);
        }
      }
        
    }
    
    //searches for a movies by title
    public Movie findMovie(String title){
        for(Movie movie: listOfMovies){
            if(movie.getMovieTitle().equalsIgnoreCase(title)){
                return movie;
         }
        }
        System.out.println("Film not found");
        return null;
            
     }
    
    
}

