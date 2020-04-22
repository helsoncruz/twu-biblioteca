package com.twu.biblioteca;

import View.BookView;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        MenuController menuController = new MenuController();
        menuController.SelectMenuOption();
    }
}
