import java.util.ArrayList;

public class Movie {
    private String title;
    private int releaseYear;
    private ArrayList<String> genres;
    private double rating;

    // Konstruktør
    public Movie(String title, int releaseYear, ArrayList<String> genres, double rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.rating = rating;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public double getRating() {
        return rating;
    }

    // toString-metode til nem udskrivning
    @Override
    public String toString() {
        return title + " (" + releaseYear + ") | Genrer: " + String.join(", ", genres) + " | Rating: " + rating;
    }
}