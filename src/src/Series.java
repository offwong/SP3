import java.util.ArrayList;

public class Series {
    private String title;
    private String releaseYears; // F.eks. "1990-1991" eller "2008-"
    private ArrayList<String> genres;
    private double rating;
    private ArrayList<Season> seasons;

    public Series(String title, String releaseYears, ArrayList<String> genres, double rating, ArrayList<Season> seasons) {
        this.title = title;
        this.releaseYears = releaseYears;
        this.genres = genres;
        this.rating = rating;
        this.seasons = seasons;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseYears() {
        return releaseYears;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public double rating() {
        return rating;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    @Override
    public String toString() {
        return title + " (" + releaseYears + ") | Genrer: " + String.join(", ", genres) +
                " | Rating: " + rating + " | Sæsoner: " + seasons.size();
    }
}