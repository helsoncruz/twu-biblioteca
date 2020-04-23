package Repositories;

import Model.Movie;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MovieRepository {
    private ArrayList<Movie> movieList;

    public MovieRepository() {
        InitializeMovieRepository();
    }

    private void InitializeMovieRepository(){
        movieList  = new ArrayList<Movie>();
        this.movieList.add(new Movie(0,"Pulp Fiction","Quentin Tarantino", 1995, true));
        this.movieList.add(new Movie(1,"Kill Bill - Volume 1","Quentin Tarantino", 2003,true));
        this.movieList.add(new Movie(2,"Kill Bill - Volume 2","Quentin Tarantino", 2004,true));
        this.movieList.add(new Movie(3,"Django Livre","Quentin Tarantino", 2013,true));
    }

    public ArrayList<Movie> getAllAvailableMovies() {
        return (ArrayList<Movie>) movieList.stream().filter(Movie::isAvailable).collect(Collectors.toList());
    }

    public Movie CheckoutMovie(int id){
        if(IsIdValid(id) && movieList.get(id).isAvailable()){
           Movie checkedOut = movieList.get(id);
           checkedOut.setAvailable(false);
           return checkedOut;
        }
        return null;
    }

    private boolean IsIdValid(int id){
        if(movieList.stream().noneMatch(s->s.getMovieId() == id)){
            return false;
        }
        return true;
    }
}
