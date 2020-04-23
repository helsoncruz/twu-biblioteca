package View;

import Model.Movie;
import Repositories.MovieRepository;

import java.util.ArrayList;

public class MovieView {
    private final MovieRepository movieRepository;

    public MovieView(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void ShowAvailableMovies(){
        ArrayList<Movie> bookList = movieRepository.getAllAvailableMovies();
        System.out.println("Id | Name | Director | Year");
        bookList.forEach(s-> System.out.println(s.getMovieId() + " | " + s.getName()+" | "+ s.getDirector()+" | "+ s.getYear()));
    }
}
