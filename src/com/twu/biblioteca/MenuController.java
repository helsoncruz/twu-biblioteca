package com.twu.biblioteca;

import Model.Book;
import Repositories.BookRepository;
import Repositories.MovieRepository;
import View.BookView;
import View.MenuView;
import View.MovieView;

import java.util.Scanner;

public class MenuController {
    private MenuView menuView;
    private BookView bookView;
    private BookRepository bookRepository;
    private MovieRepository movieRepository;
    private MovieView movieView;

    public MenuController() {
        bookRepository = new BookRepository();
        movieRepository = new MovieRepository();
        bookView = new BookView(bookRepository);
        menuView = new MenuView(bookRepository);
        movieView = new MovieView(movieRepository);
    }

    public void SelectMenuOption(){
        int chooserOption = -1;
        Scanner scan = new Scanner(System.in);
        menuView.ShowAllMenuOptions();
        while(chooserOption < 0 || chooserOption > 4){
            System.out.println("Choose a menu option id:");
            while(!scan.hasNextInt()){
                System.out.println("Please, insert only the ID:");
                scan.next();
            }
            chooserOption = scan.nextInt();
            switch (chooserOption){
                case 1: bookView.ShowAllAvailableBooks(); break;
                case 2: CheckoutBook();break;
                case 3: ReturnABook();break;
                case 4: movieView.ShowAvailableMovies();break;
                case 0: EndTheApplication();break;
                default: System.out.println("Please select a valid option!");break;
            }
        }
    }

    private void EndTheApplication(){
        System.out.println("Bye Bye, see you soon!");
        System.exit(0);
    }

    private void CheckoutBook(){
        int bookId;
        Book choosedBook;
        System.out.println("\nThese are all available books:");
        bookView.ShowAllAvailableBooks();
        do{
            System.out.println("Please, choose the id of book that you want:");
            Scanner scan = new Scanner(System.in);
            while(!scan.hasNextInt()){
                System.out.println("Please, insert only the ID:");
                scan.next();
            }
            bookId = scan.nextInt();
            choosedBook = bookRepository.CheckoutBook(bookId);
            if(choosedBook == null){
                System.out.println("Sorry! That book is not available! \n");
            }
        }while(choosedBook == null);
        System.out.println("Thank you! Enjoy the book! \n");
        SelectMenuOption();
    }

    private void ReturnABook(){
        int bookId;
        boolean returned = false;
        boolean tryAgain = true;
        System.out.println("\nThese are all unavailable books:");
        bookView.ShowAllUnavailableBooks();
        while(tryAgain) {
            System.out.println("Please, enter the id of the book you want to return\n:");
            Scanner scan = new Scanner(System.in);
            while (!scan.hasNextInt()) {
                System.out.println("Please, insert only the ID:");
                scan.next();
            }
            bookId = scan.nextInt();
            returned = bookRepository.ReturnABook(bookId);
            if (returned) {
                tryAgain = false;
                System.out.println("Thank you for returning the book! \n");
                SelectMenuOption();
            } else {
                System.out.println("That is not a valid book to return.");
            }
        }
    }
}
