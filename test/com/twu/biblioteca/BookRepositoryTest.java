package com.twu.biblioteca;
import Repositories.BookRepository;
import Model.Book;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookRepositoryTest {
    BookRepository repository = new BookRepository();
    @Test
    public void RepositoryIsNotEmpty() {
        ArrayList<Book> bookList = repository.getAvailableBookList();
        assertThat(bookList.isEmpty(), is(false));
    }

    @Test
    public void ReturnValidBookWhenTryToCheckout(){
        Book checkedOutBook = repository.CheckoutBook(0);
        Book book1 = new Book(0,"Helson", "Book 1", 2010,true);
        assertThat(checkedOutBook.getTitle(), is(equalTo(book1.getTitle())));
    }

    @Test
    public void ReturnNotValidBookWhenTryToCheckout(){
        Book checkedOutBook = repository.CheckoutBook(0);
        Book checkedOutBook2 = repository.CheckoutBook(0);
        assertThat(checkedOutBook2, is(equalTo(null)));
    }

    @Test
    public void TheBookIsNotAvailableAfterCheckOut(){
        int id = 1;
        Book checkedOutBook = repository.CheckoutBook(id);
        Book getBook = repository.getAllBooks().get(id);
        boolean isAvailable = getBook.isAvailable();
        assertThat(isAvailable, is(false));
    }

    @Test
    public void ShouldReturnBookSuccessfully(){
        Book checkedOutBook = repository.CheckoutBook(1);
        boolean returned = repository.ReturnABook(checkedOutBook.getBookId());
        boolean isAvailable = repository.getAllBooks().get(checkedOutBook.getBookId()).isAvailable();
        assertThat(isAvailable, is(true));
    }
}
