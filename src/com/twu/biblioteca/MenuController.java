package com.twu.biblioteca;

import View.BookView;
import View.MenuView;

import java.util.Scanner;

public class MenuController {
    private MenuView menuView;
    private BookView bookView;

    public MenuController() {
        menuView = new MenuView();
        bookView = new BookView();
    }

    public void SelectMenuOption(){
        Scanner scan = new Scanner(System.in);
        menuView.ShowAllMenuOptions();
        System.out.println("Choose a menu option id:");
        int choosedOption = scan.nextInt();
        if(choosedOption == 1){
            bookView.ShowAllBooksAvailable();
        }
    }


}
