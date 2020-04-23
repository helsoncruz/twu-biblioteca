package com.twu.biblioteca;

import Model.Book;
import Model.Customer;
import Model.Movie;
import Repositories.BookRepository;
import Repositories.CustomerRepository;
import Repositories.MovieRepository;
import View.BookView;
import View.MenuView;
import View.MovieView;

import java.util.Scanner;

public class MenuController {
    private MenuView menuView;
    private Customer customerAuthenticated;
    private BookController bookController;
    private MovieController movieController;
    private CustomerController customerController;

    public MenuController() {
        bookController = new BookController();
        movieController = new MovieController();
        menuView = new MenuView();
        customerController = new CustomerController();
        customerAuthenticated = new Customer();
    }

    public void SelectMenuOption(){
        int chooserOption = -1;
        Scanner scan = new Scanner(System.in);
        while(chooserOption != 0){
            boolean autheticated = customerAuthenticated.getLibraryNumber() != null;
            menuView.ShowAllMenuOptions(bookController.GetBookRepository(), autheticated);
            System.out.println("\n\nChoose a menu option id:");
            while(!scan.hasNextInt()){
                System.out.println("Please, insert only the ID:");
                scan.next();
            }
            chooserOption = scan.nextInt();
            switch (chooserOption){
                case 1: bookController.ShowAvailableBooks(); break;
                case 2: bookController.CheckoutBook(); break;
                case 3: bookController.ReturnABook(); break;
                case 4: movieController.ShowAvailableMovies(); break;
                case 5: movieController.CheckoutAMovie(); break;
                case 6: customerAuthenticated = customerController.LogIn(); break;
                case 7: customerController.ShowCustomerInformation(customerAuthenticated); break;
                case 0: EndTheApplication();break;
                default: System.out.println("Please select a valid option!");break;
            }
        }
    }

    private void EndTheApplication(){
        System.out.println("Bye Bye, see you soon!");
        System.exit(0);
    }


}
