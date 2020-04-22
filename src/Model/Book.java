package Model;

public class Book {
    private int BookId;
    private String Author;
    private String Title;
    private int PublicationYear;
    private boolean Available;

    public Book(int id, String author, String title, int publicationYear, boolean available) {
        BookId = id;
        Author = author;
        Title = title;
        PublicationYear = publicationYear;
        Available = available;
    }

    public int getPublicationYear() {
        return PublicationYear;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }

    public String getAuthor() {
        return Author;
    }

    public String getTitle() {
        return Title;
    }

    public int getBookId() {
        return BookId;
    }
}
