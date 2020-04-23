package Repositories;

import Model.Book;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BookRepository {
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public BookRepository() {
        InitializeBookList();
    }

    public ArrayList<Book> getAvailableBookList() {
        return (ArrayList<Book>) bookList.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    public ArrayList<Book> getAllBooks() {
        return bookList;
    }

    public ArrayList<Book> getUnavailableBookList() {
        return (ArrayList<Book>) bookList.stream().filter(s-> !s.isAvailable()).collect(Collectors.toList());
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    private void InitializeBookList(){
        this.bookList.add(new Book(0,"Helson", "Book 1", 2010, true));
        this.bookList.add(new Book(1,"Peter", "Book 2", 2000, true));
        this.bookList.add(new Book(2,"John", "Book 3", 2020,true));
        this.bookList.add(new Book(3,"Alicia", "Book 4", 2019,true));
        this.bookList.add(new Book(4,"Mary", "Book 5", 1992,true));
    }

    public Book CheckoutBook(int id){
        if(ThisIsvalidId(id)){
            Book checkedOut = bookList.get(id);
            if(!checkedOut.isAvailable()) {
                return null;
            }
            bookList.get(id).setAvailable(false);
            return checkedOut;
        }
        return null;
    }

    public boolean ReturnABook(int id){
        if(ThisIsvalidId(id) && !bookList.get(id).isAvailable()){
            Book bookReturned = bookList.get(id);
            bookReturned.setAvailable(true);
            return bookReturned.isAvailable();
        }
        return false;
    }

    private boolean ThisIsvalidId(int id){
        if(bookList.stream().noneMatch(s->s.getBookId() == id)){
            return false;
        }
        return true;
    }
}
