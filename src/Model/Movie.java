package Model;

public class Movie {
    private int MovieId;
    private String Name;
    private String Director;
    private int Year;
    private boolean Available;

    public Movie(int movieId, String name, String director, int year, boolean available) {
        MovieId = movieId;
        Name = name;
        Director = director;
        Year = year;
        Available = available;
    }

    public int getMovieId() {
        return MovieId;
    }

    public void setMovieId(int movieId) {
        MovieId = movieId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }
}
