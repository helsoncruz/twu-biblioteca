package com.twu.biblioteca;

import Model.Movie;
import Repositories.MovieRepository;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class MovieRepositoryTest {
    MovieRepository repository = new MovieRepository();

    @Test
    public void VerifyThatRepositoryIsNotEmpty(){
        ArrayList<Movie> movieList = repository.getAllAvailableMovies();
        assertThat(movieList.isEmpty(), is(false));
    }

    @Test
    public void ShouldAllMoviesAreAvailable(){
        ArrayList<Movie> movieList = repository.getAllAvailableMovies();
        assertThat(movieList.stream().anyMatch(s->!s.isAvailable()), is(false));
    }

    @Test
    public void ReturnValidMovieWhenTryToCheckout(){
        Movie rentedMovie = repository.CheckoutMovie(1);
        assertThat(rentedMovie != null && !rentedMovie.isAvailable(), is(true));
    }
}
