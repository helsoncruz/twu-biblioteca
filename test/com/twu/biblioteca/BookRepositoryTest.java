package com.twu.biblioteca;
import Repositories.BookRepository;
import Model.Book;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookRepositoryTest {
    BookRepository repository = new BookRepository();
    @Test
    public void RepositoryIsNotEmpty() {
        ArrayList<Book> bookList = repository.getBookList();
        assertFalse(bookList.isEmpty());
    }

    @Test
    public void ReturnValidBookWhenTryToCheckout(){
        Book checkedOutBook = repository.CheckoutBook(0);
        Book book1 = new Book(0,"Helson", "Book 1", 2010,true);
        assertSame(checkedOutBook.getTitle(), book1.getTitle());
    }

    @Test
    public void ReturnNotValidBookWhenTryToCheckout(){
        Book checkedOutBook = repository.CheckoutBook(0);
        Book checkedOutBook2 = repository.CheckoutBook(0);
        assertNull(checkedOutBook2);
    }

    @Test
    public void ThereIsAnyBookNotAvailableAfterCheckOut(){
        Book checkedOutBook = repository.CheckoutBook(1);
        assertTrue(repository.getBookList().stream().anyMatch(s-> !s.isAvailable()));
    }
}
