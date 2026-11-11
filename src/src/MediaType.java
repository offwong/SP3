import java.util.ArrayList;

public abstract class MediaType {

    private String title;
    private int releasePeriod;
    private ArrayList<Genre> genres;
    private double rating;

    public MediaType(String title, int releasePeriod, ArrayList<Genre> genres, double rating) {
        this.title = title;
        this.releasePeriod = releasePeriod;
        this.genres = genres;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getReleasePeriod() {
        return releasePeriod;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return title + " (" + releasePeriod + ") Rating: " + rating;
    }
}