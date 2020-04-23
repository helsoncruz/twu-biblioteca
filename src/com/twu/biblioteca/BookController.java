package com.twu.biblioteca;

import Model.Book;
import Repositories.BookRepository;
import View.BookView;

import java.util.Scanner;

public class BookController {
    private BookRepository bookRepository;
    private BookView bookView;

    public BookController() {
        this.bookRepository = new BookRepository();
        this.bookView = new BookView(bookRepository);
    }

    public void CheckoutBook(){
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
    }

    public void ReturnABook(){
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
            } else {
                System.out.println("That is not a valid book to return.");
            }
        }
    }

    public void ShowAvailableBooks(){
        bookView.ShowAllAvailableBooks();
    }

    public BookRepository GetBookRepository(){
        return this.bookRepository;
    }
}
