package Repositories;

import Model.Book;
import java.util.ArrayList;

public class BookRepository {
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public BookRepository() {
        InitializeBookList();
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    private void InitializeBookList(){
        this.bookList.add(new Book("Helson", "Book 1", 2010));
        this.bookList.add(new Book("Peter", "Book 2", 2000));
        this.bookList.add(new Book("John", "Book 3", 2020));
        this.bookList.add(new Book("Alicia", "Book 4", 2019));
        this.bookList.add(new Book("Mary", "Book 5", 1992));
    }
}
