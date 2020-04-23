package View;

import Model.Book;
import Repositories.BookRepository;

import java.util.ArrayList;

public class BookView {
    private final BookRepository bookRepository;

    public BookView(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void ShowAllAvailableBooks(){
        ArrayList<Book> bookList = bookRepository.getAvailableBookList();
        System.out.println("Id | Title | Author | Year");
        bookList.forEach(s-> System.out.println(s.getBookId() + " | " + s.getTitle()+" | "+ s.getAuthor()+" | "+ s.getPublicationYear()));
    }

    public void ShowAllUnavailableBooks(){
        ArrayList<Book> bookList = bookRepository.getUnavailableBookList();
        System.out.println("Id | Title | Author | Year");
        bookList.forEach(s-> System.out.println(s.getBookId() + " | " + s.getTitle()+" | "+ s.getAuthor()+" | "+ s.getPublicationYear()));
    }
}
