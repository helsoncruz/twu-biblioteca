package com.twu.biblioteca;

import Model.Book;
import Repositories.BookRepository;
import View.BookView;
import View.MenuView;

import java.util.Scanner;

public class MenuController {
    private MenuView menuView;
    private BookView bookView;
    private BookRepository bookRepository;

    public MenuController() {
        menuView = new MenuView();
        bookRepository = new BookRepository();
        bookView = new BookView(bookRepository);
    }

    public void SelectMenuOption(){
        int chooserOption = -1;
        Scanner scan = new Scanner(System.in);
        menuView.ShowAllMenuOptions();
        while(chooserOption < 0 || chooserOption > 2){
            System.out.println("Choose a menu option id:");
            while(!scan.hasNextInt()){
                System.out.println("Please, insert only the ID:");
                scan.next();
            }
            chooserOption = scan.nextInt();
            switch (chooserOption){
                case 1: bookView.ShowAllBooksAvailable(); break;
                case 2: CheckoutBook();break;
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
        bookView.ShowAllBooksAvailable();
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
}
