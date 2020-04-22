package com.twu.biblioteca;
import Repositories.BookRepository;
import Model.Book;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookRepositoryTest {
    @Test
    public void RepositoryIsNotEmpty() {
        BookRepository repository = new BookRepository();
        ArrayList<Book> bookList = repository.getBookList();
        assertFalse(bookList.isEmpty());
    }
}
