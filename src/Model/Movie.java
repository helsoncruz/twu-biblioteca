package Model;

public class Movie {
    private int MovieId;
    private String Name;
    private String Director;
    private int Year;
    private boolean Available;

    public Movie(int movieId, String name, String director, int year, boolean available) {
        this.MovieId = movieId;
        this.Name = name;
        this.Director = director;
        this.Year = year;
        this.Available = available;
    }

    public int getMovieId() {
        return this.MovieId;
    }

    public void setMovieId(int movieId) {
        this.MovieId = movieId;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDirector() {
        return this.Director;
    }

    public void setDirector(String director) {
        this.Director = director;
    }

    public int getYear() {
        return this.Year;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    public boolean isAvailable() {
        return this.Available;
    }

    public void setAvailable(boolean available) {
        this.Available = available;
    }
}