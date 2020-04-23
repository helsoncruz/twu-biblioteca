package Model;

public class Book {
    private int BookId;
    private String Author;
    private String Title;
    private int PublicationYear;
    private boolean Available;

    public Book(int id, String author, String title, int publicationYear, boolean available) {
        this.BookId = id;
        this.Author = author;
        this.Title = title;
        this.PublicationYear = publicationYear;
        this.Available = available;
    }

    public int getPublicationYear() {
        return this.PublicationYear;
    }

    public boolean isAvailable() {
        return this.Available;
    }

    public void setAvailable(boolean available) {
        this.Available = available;
    }

    public String getAuthor() {
        return this.Author;
    }

    public String getTitle() {
        return this.Title;
    }

    public int getBookId() {
        return this.BookId;
    }
}
