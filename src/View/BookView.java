package View;

import Model.Book;
import Repositories.BookRepository;

import java.util.ArrayList;

public class BookView {
    private BookRepository bookRepository;

    public BookView() {
        this.bookRepository = new BookRepository();
    }

    public void ShowAllBooksAvailable(){
        ArrayList<Book> bookList = bookRepository.getBookList();
        bookList.forEach(s-> System.out.println(s.getTitle()+", "+ s.getAuthor()+", "+ s.getPublicationYear()));
    }
}
