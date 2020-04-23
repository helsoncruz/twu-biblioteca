package com.twu.biblioteca;

import Model.Movie;
import Repositories.MovieRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class MovieRepositoryTest {
    MovieRepository repository = new MovieRepository();

    @Test
    public void VerifyThatRepositoryIsNotEmpty(){
        ArrayList<Movie> movieList = repository.getAllAvailableMovies();
        assertFalse(movieList.isEmpty());
    }

    @Test
    public void ShouldAllMoviesAreAvailable(){
        ArrayList<Movie> movieList = repository.getAllAvailableMovies();
        assertFalse(movieList.stream().anyMatch(s->!s.isAvailable()));
    }

    @Test
    public void ReturnValidMovieWhenTryToCheckout(){
        Movie rentedMovie = repository.CheckoutMovie(1);
        assertTrue(rentedMovie != null && !rentedMovie.isAvailable());
    }
}
