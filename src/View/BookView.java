package View;

import Model.Book;
import Repositories.BookRepository;

import java.util.ArrayList;

public class BookView {
    private BookRepository bookRepository;

    public BookView(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void ShowAllBooksAvailable(){
        ArrayList<Book> bookList = bookRepository.getBookList();
        System.out.println("Id | Title | Author | Year");
        bookList.forEach(s-> System.out.println(s.getBookId() + " | " + s.getTitle()+" | "+ s.getAuthor()+" | "+ s.getPublicationYear()));
    }
}
