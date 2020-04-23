package Model;

import java.awt.print.Book;
import java.util.ArrayList;

public class Customer {
    private ArrayList<Book> booksWithUser;
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    public Customer(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.booksWithUser = new ArrayList();
    }

    public Customer() {
    }

    public ArrayList<Book> getOrder() {
        return this.booksWithUser;
    }

    public void addOrderBook(Book book) {
        this.booksWithUser.add(book);
    }

    public String getLibraryNumber() {
        return this.libraryNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}