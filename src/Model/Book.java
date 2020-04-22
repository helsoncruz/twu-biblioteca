package Model;

public class Book {
    private String Author;
    private String Title;
    private int PublicationYear;

    public int getPublicationYear() {
        return PublicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        PublicationYear = publicationYear;
    }

    public Book(String author, String title, int publicationYear) {
        Author = author;
        Title = title;
        PublicationYear = publicationYear;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
