package com.twu.biblioteca;

import Model.Movie;
import Repositories.MovieRepository;
import View.MovieView;

import java.util.Scanner;

public class MovieController {
    private MovieRepository movieRepository;
    private MovieView movieView;

    public MovieController() {
        movieRepository = new MovieRepository();
        movieView = new MovieView(movieRepository);
    }

    public void CheckoutAMovie() {
        int movieId;
        Movie movie;
        System.out.println("\nThese are all available movies:");
        movieView.ShowAvailableMovies();
        do{
            System.out.println("Please, choose the id of book that you want:");
            Scanner scan = new Scanner(System.in);
            while(!scan.hasNextInt()){
                System.out.println("Please, insert only the ID:");
                scan.next();
            }
            movieId = scan.nextInt();
            movie = movieRepository.CheckoutMovie(movieId);
            if(movie == null){
                System.out.println("Sorry! That movie is not available! \n");
            }
        }while(movie == null);
        System.out.println("Thank you! Enjoy the movie! \n");
    }

    public void ShowAvailableMovies(){
        movieView.ShowAvailableMovies();
    }
}
